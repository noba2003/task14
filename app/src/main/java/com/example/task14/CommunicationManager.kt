package com.example.task14

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class CommunicationManager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getStringExtra("data")

        setContent {
          Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (data != null) {
                    Header(name = data.toString())
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                    , verticalAlignment = Alignment.CenterVertically
                    ) {
                    SendDataBTN(label = "email"){sendEmail(data.toString())}
                    SendDataBTN(label = "message"){
                        sendMessage(data.toString())
                    }
                    SendDataBTN(label = "call"){
                        sendCall(data.toString())
                    }

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement = Arrangement.SpaceEvenly
                    , verticalAlignment = Alignment.CenterVertically
                ) {
                    SendDataBTN(label = "back"){
                        back("")
                    }
                    SendDataBTN(label = "website"){
                        sendWebsite(data.toString())
                    }

                }



            }
        }
    }

    fun sendEmail(data:String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = android.net.Uri.parse("mailto:$data")
        startActivity(intent)
    }
    fun sendMessage(data:String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = android.net.Uri.parse("smsto:$data")
        startActivity(intent)
    }
    fun sendCall(data:String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = android.net.Uri.parse("tel:$data")
        startActivity(intent)
    }
    fun sendWebsite(data:String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = android.net.Uri.parse("https://$data")
        startActivity(intent)
    }
    fun back(data:String) {
        finish()
    }
}

