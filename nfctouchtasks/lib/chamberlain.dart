import 'dart:async';
import 'dart:convert';
import 'dart:core';
import 'package:randombytes/randombytes.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:http/http.dart' as http;
import 'package:convert/convert.dart';

class ChamberlainAPI {
  static ChamberlainAPI _instance;
  static ChamberlainAPI get instance {
    if (_instance != null)
      return _instance;
    else
      return _instance = ChamberlainAPI();
  }

  static final storage = new FlutterSecureStorage();

  static String _generateUserAgent() => hex.encode(randomBytes(10));

  String _securityToken;
  String _userId;

  Future<void> clearData() async {
    await storage.deleteAll();
    _securityToken = null;
    _userId = null;
  }

  bool isLoggedIn() => _securityToken != null && _userId != null;

  Future<bool> credentialsExist() async {
    Map<String, String> settings = await storage.readAll();
    return settings.containsKey('username') && settings.containsKey('password');
  }

  Map get _baseHeaders => {
        "Culture": "en",
        "MyQApplicationId":
            "JVM/G9Nwih5BwKgNCjLxiFUQxQijAebyyg8QUHr7JOrP+tuPb8iHfRHKwTmDzHOu",
        "User-Agent": _generateUserAgent(),
        "Content-Type": "application/json",
        "SecurityToken": _securityToken
      };

  Future<void> login(String username, String password) async {
    http.Response res = await http.post(
        "https://api.myqdevice.com/api/v5/Login",
        headers: {..._baseHeaders},
        body: jsonEncode({"Username": username, "Password": password}));
    Map<String, dynamic> json = jsonDecode(res.body);
    if (res.statusCode != 200) return Future.error(json["description"]);
    _securityToken = json['SecurityToken'];

    {
      http.Response res = await http.get("https://api.myqdevice.com/api/v5/My",
          headers: {..._baseHeaders});
      Map<String, dynamic> json = jsonDecode(res.body);
      if (res.statusCode != 200) return Future.error(json["description"]);
      _userId = json["UserId"];
    }
  }

  Future<void> setDoorState(String serial, bool open) async {
    if (!isLoggedIn()) return Future.error("Not logged in!");

    http.Response res = await http.put(
        "https://api.myqdevice.com/api/v5.1/Accounts/$_userId/Devices/$serial/actions",
        headers: {..._baseHeaders},
        body: jsonEncode({"action_type": (open) ? "open" : "close"}));
    if (res.statusCode != 204) {
      Map<String, dynamic> json = jsonDecode(res.body);
      return Future.error(json["description"]);
    }
  }
}
