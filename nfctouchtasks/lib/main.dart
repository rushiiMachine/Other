import 'package:flutter/material.dart';

// Routes
import './routes/home.dart';
import './routes/login.dart';
import './routes/settings.dart';

void main() {
  runApp(App());
}

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'NFC Touch Tasks',
        theme: ThemeData(
          primarySwatch: Colors.blue,
          visualDensity: VisualDensity.adaptivePlatformDensity,
        ),
        initialRoute: '/',
        routes: {
          '/': (context) => Home(),
          '/login': (context) => Login(),
          '/settings': (context) => Settings()
        });
  }
}
