package com.nate.memoir.ui.theme.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nate.memoir.data.AuthViewModel
import com.nate.memoir.navigation.ROUTE_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    var answer by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Login here",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =email , onValueChange = {email=it},
            label = { Text(text = "Enter Email", color = Color.LightGray) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter Password", color = Color.LightGray) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

//        Button(onClick = {
//            val mylogin=AuthViewModel(navController, context )
//            mylogin.login(email.text.trim(),pass.text.trim())
//            if (email.text.isEmpty() || pass.text.isEmpty()){
//                answer = "Please input correct email and password"
//            }
//           }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) {
//            Text(text = "Log In", color = Color.White)
//        }

        Button(onClick = {
            val mylogin = AuthViewModel(navController, context)
            if (email.text.trim().isNotEmpty() && pass.text.trim().isNotEmpty()) {
                mylogin.login(email.text.trim(), pass.text.trim())
            } else {
                answer = "Please input correct email and password"
            }
        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) {
            Text(text = "Log In", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) {
            Text(text = "Don't have account? Click to Register", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = answer,
            color = Color.White,
            fontSize = 10.sp)

    }


}
@Preview
@Composable
fun Loginpage() {
    LoginScreen(rememberNavController())
}