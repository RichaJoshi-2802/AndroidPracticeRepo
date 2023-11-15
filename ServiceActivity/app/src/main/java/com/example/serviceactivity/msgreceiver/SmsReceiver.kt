package com.example.serviceactivity.msgreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log


class SmsReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras
        val smsObj = bundle?.getByteArray("pdus")

        val message = SmsMessage.createFromPdu(smsObj)
        val phno = message.displayOriginatingAddress
        val msg = message.displayMessageBody.toString()
        Log.d("MsgDetails", "MobNo: $phno Msg: $msg")

    }
}