package com.lecture2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lecture2.MainActivity

/**
 * フラッシュライトのオン/オフを制御するボタン
 *
 */
@Composable
fun FlashLightButtons(activity: MainActivity?, modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(bottom = 16.dp))

    {
        Text(
            text = "フラッシュライト",
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column {
            // ONボタン
            Button(
                onClick = { activity?.toggleLight(true) },
                colors = ButtonDefaults.textButtonColors(Color(200,200,255)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "ON", color = Color.Blue)
            }
            Button(
                onClick = { activity?.toggleLight(false) },
                colors = ButtonDefaults.textButtonColors(Color(255,200,200)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "OFF", color = Color.Red)
            }



        }


    }
}
