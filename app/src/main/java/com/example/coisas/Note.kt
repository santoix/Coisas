package com.example.coisas

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.coisas.ui.theme.BlackL
import com.example.coisas.ui.theme.CoisasTheme

//redudante por enquanto planos para depois
@Composable
fun Note(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "NotePad", fontSize = 40.sp, color = BlackL)

        }
    }
}

@Preview
@Composable
fun NotePreview(){
    CoisasTheme {
        Note()
    }
}