package com.nate.memoir.data
//
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import com.nate.memoir.ui.theme.focusedTextFieldText
//import com.nate.memoir.ui.theme.textFieldContainer
//import com.nate.memoir.ui.theme.unfocusedTextFieldText
//import androidx.compose.material3.*
//import com.nate.memoir.navigation.ROUTE_REGISTER
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginTextField(
//    modifier: Modifier = Modifier,
//    label: String,
//    trailing: String,
//) {
//
//    val uiColor = Color.White
//
//
//
//    TextField (
//        modifier = modifier,
//        value = "",
//        onValueChange= {},
//        label= {
//            Text(text = label, style = MaterialTheme.typography.labelMedium, color=uiColor)
//        },
//
//        colors = TextFieldDefaults.colors(
//            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
//            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
//            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
//            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
//        ),
//        trailingIcon = {
//            TextButton(onClick = { navController.navigate(ROUTE_REGISTER) }) {
//                Text(text = trailing, style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
//                    color = uiColor)
//
//            }
//        }
//    )
//
//}