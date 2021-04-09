import 'package:flutter/material.dart';
import '../chamberlain.dart';

class Login extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final _scaffoldKey = GlobalKey<ScaffoldState>();
  final TextEditingController _emailFilter = TextEditingController();
  final TextEditingController _passwordFilter = TextEditingController();
  String _email = "";
  String _password = "";

  bool _hidePassword = true;

  _LoginState() {
    _emailFilter.addListener(() {
      if (_emailFilter.text.isEmpty)
        _email = "";
      else
        _email = _emailFilter.text;
    });
    _passwordFilter.addListener(() {
      if (_passwordFilter.text.isEmpty)
        _password = "";
      else
        _password = _passwordFilter.text;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: _scaffoldKey,
      appBar: AppBar(
        title: Text("Login to Chamberlain MyQ"),
        centerTitle: true,
      ),
      body: Container(
        padding: EdgeInsets.all(16.0),
        child: Column(
          children: <Widget>[
            Container(
              child: Column(
                children: <Widget>[
                  Container(
                    child: TextField(
                      controller: _emailFilter,
                      decoration: InputDecoration(
                          labelText: 'Email', icon: Icon(Icons.email)),
                    ),
                  ),
                  Container(
                    child: TextField(
                      controller: _passwordFilter,
                      decoration: InputDecoration(
                          labelText: 'Password',
                          icon: Icon(Icons.lock),
                          suffixIcon: IconButton(
                            onPressed: () => this.setState(() {
                              _hidePassword = !_hidePassword;
                            }),
                            icon: Icon(_hidePassword
                                ? Icons.visibility_off
                                : Icons.visibility),
                          )),
                      obscureText: _hidePassword,
                      enableSuggestions: false,
                    ),
                  )
                ],
              ),
            ),
            Container(
              child: Column(
                children: <Widget>[
                  RaisedButton(
                    child: Text('Login'),
                    onPressed: _loginPressed,
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }

  void _loginPressed() async {
    FocusScope.of(context).unfocus();
    if (_email == "" || _password == "") {
      _scaffoldKey.currentState.showSnackBar(SnackBar(
        content: Text('Username or Password cannot be empty!'),
      ));
      return;
    }

    _scaffoldKey.currentState.showSnackBar(SnackBar(
      content: Text('Logging in...'),
      duration: Duration(minutes: 1),
    ));

    ChamberlainAPI.instance
        .login(_email, _password)
        .then((_) => {
              Navigator.pop(context),
              ChamberlainAPI.storage.write(key: "username", value: _email),
              ChamberlainAPI.storage.write(key: "password", value: _password)
            })
        .catchError((e) => {
              _scaffoldKey.currentState.hideCurrentSnackBar(),
              _scaffoldKey.currentState.showSnackBar(SnackBar(
                content: Text(e),
                duration: Duration(seconds: 2),
              )),
              ChamberlainAPI.instance.clearData()
            });
  }
}
