package com.nate.memoir.ui.theme.screens.register

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nate.memoir.R
import com.nate.memoir.data.AuthViewModel
import com.nate.memoir.data.rememberImeState
import com.nate.memoir.navigation.ROUTE_LOGIN
import com.nate.memoir.navigation.ROUTE_REGISTER
import com.nate.memoir.ui.theme.BlueGray
import com.nate.memoir.ui.theme.focusedTextFieldText
import com.nate.memoir.ui.theme.textFieldContainer
import com.nate.memoir.ui.theme.unfocusedTextFieldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value){
        if (imeState.value){
            scrollState.animateScrollTo(scrollState.maxValue, tween(350))
        }
    }


    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current

    // Create the AuthViewModel outside of the onClick function
    val myregister = remember { AuthViewModel(navController,context) }

    Surface {
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.Black).verticalScroll(scrollState)){

            val uiColor = Color.White

            Box(contentAlignment = Alignment.TopCenter){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(fraction = 0.46f),
                    painter = painterResource(id = R.drawable.shape), contentDescription = null,
                    contentScale = ContentScale.FillBounds)

                Row (modifier = Modifier.padding(top = 50.dp),
                    verticalAlignment = Alignment.CenterVertically){

                    Image(painter = painterResource(id = R.drawable.mainlog), contentDescription = "mainlog", modifier = Modifier.size(130.dp))

                }
            }

            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(horizontal = 110.dp),
                text = "Register",
                style = MaterialTheme.typography.headlineLarge,
                color = uiColor
            )

            Spacer(modifier = Modifier.height(36.dp))

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                TextField (
                    modifier = modifier,
                    value = email,
                    onValueChange= {email=it},
                    label= {
                        Text(text = "Email", style = MaterialTheme.typography.labelMedium, color=uiColor)
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),

                    colors = TextFieldDefaults.colors(
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                        unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField (
                    modifier = modifier,
                    value = pass,
                    onValueChange= {pass=it},
                    label= {
                        Text(text = "Password", style = MaterialTheme.typography.labelMedium, color=uiColor)
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),

                    colors = TextFieldDefaults.colors(
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                        unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                    ),
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField (
                    modifier = modifier,
                    value = confirmpass,
                    onValueChange= {confirmpass=it},
                    label= {
                        Text(text = "Confirm Password", style = MaterialTheme.typography.labelMedium, color=uiColor)
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),

                    colors = TextFieldDefaults.colors(
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
                        unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                        focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    onClick = { myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BlueGray,
                        contentColor = Color.White
                    ), shape = RoundedCornerShape(size = 4.dp)
                ) {

                    Text(text = "Register", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))

                }

                Spacer(modifier = Modifier.height(12.dp))

                Box(modifier = Modifier
                    .fillMaxHeight(fraction = 0.8f)
                    .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter){

                    Text(modifier = Modifier.clickable { navController.navigate(ROUTE_LOGIN) },text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF94A3B8),
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Normal
                            )
                        ){
                            append("Already have account?")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = uiColor,
                                fontSize = 14.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Medium
                            )
                        ){
                            append(" ")
                            append("Log in")
                        }
                    })

                }


            }

        }
    }





//    Column(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.DarkGray),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        Text(text = "Register here",
//            color = Color.White,
//            fontFamily = FontFamily.SansSerif,
//            fontSize = 30.sp)
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = email, onValueChange = { email = it },
//            label = { Text(text = "Enter Email", color = Color.LightGray)},
//
//            keyboardOptions = KeyboardOptions . Default . copy (imeAction = ImeAction.Next),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//
//            )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(value =pass , onValueChange = {pass=it},
//            label = { Text(text = "Enter password", color = Color.LightGray) },
//            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//        OutlinedTextField(value =confirmpass , onValueChange = {
//            confirmpass=it},
//            label = { Text(text = "Enter Confirm Pass", color = Color.LightGray) },
//
//            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Button(onClick = {
//            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
//        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) {
//            Text(text = "Register ", color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Button(onClick = {
//            navController.navigate(ROUTE_LOGIN)
//        }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)) {
//            Text(text = "Have an Account? Click to Login", color = Color.White)
//        }
//    }
}


@Preview
@Composable
fun register() {
    RegisterScreen(rememberNavController())

}