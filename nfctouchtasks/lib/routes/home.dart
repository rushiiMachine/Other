import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import '../chamberlain.dart';

class Home extends StatefulWidget {
  @override
  HomeState createState() => HomeState();
}

class HomeState extends State<Home> {
  final _scaffoldKey = GlobalKey<ScaffoldState>();

  static const _channel =
      MethodChannel('com.github.diamondminer88.nfctouchtasks/main');

  void showSnackbar(String e) {
    _scaffoldKey.currentState.showSnackBar(SnackBar(
      content: Text(e),
      duration: Duration(seconds: 1),
    ));
  }

  Future<dynamic> _platformCallHandler(MethodCall call) async {
    if (call.method != "discoveredTag") return;
    try {
      switch (call.arguments[0][1]) {
        case "open_garage_door":
          {
            Map<String, String> settings =
                await ChamberlainAPI.storage.readAll();
            await ChamberlainAPI.instance
                .login(settings['username'], settings['password']);

            await ChamberlainAPI.instance
                .setDoorState(call.arguments[1][1], true);
            SystemNavigator.pop();
          }
      }
    } catch (e) {
      showSnackbar(e);
    }
  }

  @override
  void initState() {
    super.initState();
    _channel.setMethodCallHandler(_platformCallHandler);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        key: _scaffoldKey,
        appBar: AppBar(
          title: Text('NFC Touch Tasks'),
          actions: [
            IconButton(
              onPressed: () => Navigator.pushNamed(context, '/settings'),
              icon: Icon(Icons.settings),
            )
          ],
        ),
        body: Center(
          child: Column(
            children: [
              RaisedButton(
                onPressed: () async {
                  if (!await ChamberlainAPI.instance.credentialsExist())
                    Navigator.pushNamed(context, '/login');
                  else {
                    Map<String, String> settings =
                        await ChamberlainAPI.storage.readAll();
                    ChamberlainAPI.instance
                        .login(settings['username'], settings['password'])
                        .catchError((e) => showSnackbar(e))
                        .then((_) => showSnackbar('Success!'));
                  }
                },
                child: Text('Login'),
              ),
              RaisedButton(
                onPressed: () => ChamberlainAPI.instance
                    .setDoorState("CG08004F48DC", true)
                    .then((_) => showSnackbar('Success!'))
                    .catchError((e) => showSnackbar(e)),
                child: Text('Open Garage Door'),
              ),
              RaisedButton(
                onPressed: () => ChamberlainAPI.instance
                    .setDoorState("CG08004F48DC", false)
                    .then((_) => showSnackbar('Success!'))
                    .catchError((e) => showSnackbar(e)),
                child: Text('Close Garage Door'),
              )
            ],
          ),
        ));
  }
}
