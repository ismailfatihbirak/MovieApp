package com.example.movieapp.presentation.splash

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_splash),
            contentDescription = "",
            tint = colorResource(id = R.color.primary_blue)
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextTitle()
    }
    LaunchedEffect(true) {
        delay(1000)
        navController.navigate("home")
    }
}


@Composable
fun TextTitle() {
    Text(
        text = "RUISMOVIE",
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        color = colorResource(id = R.color.primary_blue)
    )
}