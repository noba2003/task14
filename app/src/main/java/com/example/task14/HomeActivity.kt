package com.example.task14

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text(text = "eeeeeeeeeeeee")
            val data : MutableState<String> = remember { mutableStateOf("") }
            Messenger("Send",data){
                SendDatatoCommunicationManger(data = data.value)
            }

        }

    }
 private   fun SendDatatoCommunicationManger(data:String) {
        var intent = Intent(this, CommunicationManager::class.java)
        intent.putExtra("data", data)
        startActivity(intent)



    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")}

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}

