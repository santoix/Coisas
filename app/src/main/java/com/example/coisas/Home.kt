package com.example.coisas

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coisas.ui.theme.BlackL
import com.example.coisas.ui.theme.CoisasTheme
import com.example.coisas.ui.theme.testeroboto

@Composable
fun Home(){
    val image = painterResource(R.drawable.img_20200520_011424_307__1_)
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = image, contentDescription = "euzinho" )
            Text(text = "Home", fontSize = 40.sp, color = BlackL, fontFamily = testeroboto)
            Text(text = "Em construção", fontSize = 39.sp, color = BlackL, fontFamily = testeroboto)
        }

    }

}

@Preview
@Composable
fun HomePreview(){
    CoisasTheme {
        Home()
    }
}
