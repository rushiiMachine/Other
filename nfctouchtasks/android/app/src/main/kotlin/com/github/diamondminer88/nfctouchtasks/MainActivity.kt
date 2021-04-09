package com.github.diamondminer88.nfctouchtasks

import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    lateinit var channel: MethodChannel

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.github.diamondminer88.nfctouchtasks/main")
        channel.setMethodCallHandler { _: MethodCall, result: MethodChannel.Result ->
            result.success(null)
        }
    }

    @ExperimentalStdlibApi
    override fun onResume() {
        super.onResume()
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)?.also { rawMessages ->
                val messages: List<NdefMessage> = rawMessages.map { it as NdefMessage }
                channel.invokeMethod("discoveredTag", messages[0].records.map { record -> listOf(record.type.decodeToString(), record.payload.decodeToString()) }.dropLast(1))
            }
        }
    }
}
