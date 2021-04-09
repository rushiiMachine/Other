import 'package:flutter/material.dart';
import '../chamberlain.dart';

class Settings extends StatefulWidget {
  @override
  SettingsState createState() => SettingsState();
}

class SettingsState extends State<Settings> {
  final GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        key: _scaffoldKey,
        appBar: AppBar(title: Text('Settings')),
        body: Container(
          padding: EdgeInsets.all(16.0),
          child: Center(
            child: Column(
              children: [
                RaisedButton(
                    child: Text('Clear data/logout'),
                    onPressed: () => ChamberlainAPI.instance.clearData().then(
                        (_) => _scaffoldKey.currentState.showSnackBar(SnackBar(
                              content: Text('Cleared data'),
                            )))),
              ],
            ),
          ),
        ));
  }
}
