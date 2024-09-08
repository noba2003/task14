package com.example.task14

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun Messenger(labelBTN: String, UserInput: MutableState<String>,sendData:  () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserInputField(UserInput)
        SendDataBTN( labelBTN, sendData)
    }

}

/**/

@Composable
fun UserInputField(nameState: MutableState<String>) {

    TextField(
        value = nameState.value,
        onValueChange = { nameState.value = it },
        label = { Text("inter your data") }
    )
}

@Composable
fun SendDataBTN( label: String, sendData: () -> Unit) {
    Button(onClick = { sendData() }) {
        Text(text = label)

    }
}
@Composable
fun Header(name: String) {
    Text(
        text = " $name", style = TextStyle(
            color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        )
}
