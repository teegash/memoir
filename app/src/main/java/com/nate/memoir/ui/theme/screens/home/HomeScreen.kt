package com.nate.memoir.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nate.memoir.data.productviewmodel
import com.nate.memoir.navigation.ROUTE_ADD_PRODUCT
import com.nate.memoir.navigation.ROUTE_CLOUD_SCREEN
import com.nate.memoir.navigation.ROUTE_HOME
import com.nate.memoir.navigation.ROUTE_VIEW_PRODUCT
import com.nate.memoir.navigation.ROUTE_VIEW_UPLOAD
import com.nate.memoir.ui.theme.LightBlue

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
        var productdata= productviewmodel(navController,context)

        Text(text = "Welcome to Home page",
            color = Color.White,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCT)
        },modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(LightBlue)) {
            Text(text = "Add Product", color = Color.White)
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT)
        },modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(LightBlue)) {
            Text(text = "View Product", color = Color.White)
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_UPLOAD)
        },modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(LightBlue)) {
            Text(text = "View Upload", color = Color.White)
        }

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_CLOUD_SCREEN)
        }) {
            Text(text = "See the Cloud")
        }


    }

}

@Preview
@Composable
fun Homepreview() {
    HomeScreen(rememberNavController())
}