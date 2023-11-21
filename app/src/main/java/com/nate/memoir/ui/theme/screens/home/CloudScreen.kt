package com.nate.memoir.ui.theme.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.nate.memoir.navigation.ROUTE_CLOUD_SCREEN
import com.nate.memoir.navigation.ROUTE_HOME
import com.nate.memoir.navigation.ROUTE_UPDATE_PRODUCT

@Composable
fun CloudDance(navController: NavHostController) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.dancloudn))

    // State of animation for composition
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever  // This will make the animation loop indefinitely
    )



    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(R.drawable.clouddd),
            contentDescription = "image",
//            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(),
            alignment = Alignment.Center
        )

//        Spacer(modifier = Modifier.height(20.dp))
//        Spacer(modifier = Modifier.height(20.dp))
//        Spacer(modifier = Modifier.height(20.dp))

//        LottieAnimation(
//            modifier = Modifier
//                .size(400.dp)
//                .clickable { navController.navigate(ROUTE_HOME) }
//                .clip(
//                    RoundedCornerShape(20.dp)
//                ),


        LottieAnimation(
            modifier = Modifier
                .size(400.dp),
            composition = composition,
            progress = progress)

        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))






    }

}

//        Box(modifier = Modifier.size(400.dp)) {
//            LottieAnimation(
//                modifier = Modifier.size(400.dp).clickable { navController.navigate(ROUTE_HOME) },
//                composition = composition,
//                progress = progress
//            )
//        }
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