package com.nate.memoir.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val LightBlueGrey80 = Color(0xFF446879)
val LightBlueBright = Color(0xFF02CCFE)
val LightBlue = Color(0xFF258FC4)
val BlueGray = Color(0xFF334155)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Redrib = Color(0xFFFF0000)
val Orangeee = Color(0xFFFC7474)

val ColorScheme.focusedTextFieldText
    @Composable
    get() = Color.White

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = Color(0xFF94A3B8)

val ColorScheme.textFieldContainer
    @Composable
    get() = BlueGray.copy(alpha = 0.6f)