package com.nate.memoir.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nate.memoir.R
import com.nate.memoir.navigation.ROUTE_HOME
import com.nate.memoir.navigation.ROUTE_UPDATE_PRODUCT

@Composable
fun CloudDance(navController: NavHostController) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.savecl))

    // State of animation for composition
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever  // This will make the animation loop indefinitely
    )

    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

//        LottieAnimation(
//            modifier = Modifier.size(400.dp),
//            composition = composition,
//            progress = progress)
//
//        Button(onClick = {
//            navController.navigate(ROUTE_HOME)
//        }) {
//            Text(text = "Go Home")
//        }
//
//    }
//
//}

        Box(modifier = Modifier.clickable { /* Handle click here */ }) {
            LottieAnimation(
                modifier = Modifier.size(400.dp),
                composition = composition,
                progress = progress
            )
        }

        Button(onClick = {
            navController.navigate(ROUTE_HOME)
        }) {
            Text(text = "Go Home")
        }

    }

}