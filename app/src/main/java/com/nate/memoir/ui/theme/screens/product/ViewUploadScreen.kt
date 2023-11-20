package com.nate.memoir.ui.theme.screens.product

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconToggleButton
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.nate.memoir.R
import com.nate.memoir.data.productviewmodel
import com.nate.memoir.models.Upload
import com.nate.memoir.navigation.ROUTE_UPDATE_PRODUCT
import com.nate.memoir.ui.theme.LightBlueBright
import com.nate.memoir.ui.theme.LightBlueGrey80
import com.nate.memoir.ui.theme.Orangeee
import com.nate.memoir.ui.theme.Redrib
import java.text.DateFormat
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewUploadsScreen(navController: NavHostController) {


    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().background(Color(
        0xFF0A0A0A
    )
    )) {


        Spacer(modifier = Modifier.height(18.dp))
        Image(
            painter = painterResource(R.drawable.mainlog),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(55.dp)
                .width(150.dp)
        )




        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFF0A0A0A)).background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 5f,
                    endY = 80f
                )
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var context = LocalContext.current
            var productRepository = productviewmodel(navController, context)


            val emptyUploadState = remember { mutableStateOf(Upload("", "", "", "", "")) }
            var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

            var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent
                            ),
                            startY = 220f,
                            endY = 30f
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//            Text(text = "All uploads",
//                fontSize = 30.sp,
//                fontFamily = FontFamily.SansSerif,
//                color = Color.White)

//                Spacer(modifier = Modifier.height(20.dp))
//                Spacer(modifier = Modifier.height(20.dp))
//                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.height(15.dp))


                LazyColumn() {
                    items(uploads) {
                        UploadItem(
                            name = it.name,
                            quantity = it.quantity,
                            price = it.price,
                            imageUrl = it.imageUrl,
                            id = it.id,
                            navController = navController,
                            productRepository = productRepository
                        )

                    }
                }

            }
        }
    }
}

//@Composable
//fun MultiFloatingButton(
//    multiFloatingState: MultiFloatingState,
//    onMultiFabStateChange: (MultiFloatingState) -> Unit
//) {
//    val transition = updateTransition(targetState = multiFloatingState, label = "transition")
//
//    val rotate by transition.animateFloat (label = "rotate"){
//        if (it == MultiFloatingState.Expanded) 315f else 0f
//    }
//
//    FloatingActionButton(onClick = {
//                                   onMultiFabStateChange(
//                                       if (transition.currentState == MultiFloatingState.Expanded) {
//                                       MultiFloatingState.Collapsed
//                                       } else {
//                                           MultiFloatingState.Expanded
//                                       }
//                                   )
//                        }
//        ) {
//        Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.rotate(rotate))
//    }
//}

//val calendar = Calendar.getInstance().time
//val dateFormat = DateFormat.getDateInstance().format(calendar)
//val timeFormat = DateFormat.getTimeInstance().format(calendar)


@Composable
fun GetDateAndTime(date:String) {

    var dateFormat by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        dateFormat = DateFormat.getDateInstance().format(Calendar.getInstance().time)
    }
    Text(text = "${dateFormat}", style = TextStyle(color = Color.White, fontSize = 10.sp))

}

@Composable
fun UploadItem(name:String, quantity:String, price:String, imageUrl:String, id:String,
               navController:NavHostController, productRepository:productviewmodel) {

    val infinitetransition = rememberInfiniteTransition()
    val color by infinitetransition.animateColor(
        initialValue = Redrib,
        targetValue = Orangeee,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black), horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(text = name)
//        Text(text = quantity)
//        Text(text = price)

        Spacer(modifier = Modifier.height(20.dp))

        Card (modifier = Modifier
            .fillMaxWidth(0.70f)
            .padding(6.dp),
            shape = RoundedCornerShape(15.dp),
//            elevation = 5.dp
        ){

            Box(modifier = Modifier
                .height(160.dp)
                .fillMaxSize()) {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(232.dp)
                )
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    ))
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Transparent
                            ),
                            startY = 00f,
                            endY = 120f
                        )
                    ))
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomStart){

                    Text(name, style = TextStyle(color = Color.White, fontSize = 13.sp))

                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp)
                    .padding(vertical = 8.dp),
                    contentAlignment = Alignment.BottomEnd){

                    IconToggleButtonLike()

                }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.TopEnd){

                    GetDateAndTime(date = "")

                }
            }
        }
        Row {

            Button(onClick = {
                navController.navigate(ROUTE_UPDATE_PRODUCT + "/$id")
            }, colors = ButtonDefaults.buttonColors(contentColor = (Color.White))) {
//                Text(text = "Update")
                Icon(Icons.Outlined.Create, contentDescription = "Like")

            }
            
            Spacer(modifier = Modifier.width(20.dp))


            Button(onClick = {
                productRepository.deleteProduct(id)
            }, colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = (Color.White))) {
//                Text(text = "Delete")
                Icon(Icons.Outlined.Delete, contentDescription = "Like")
            }




        }
    }
}

@Composable
fun IconToggleButtonLike() {
    var checked by remember { mutableStateOf(false) }

    IconToggleButton(modifier = Modifier.height(15.dp), checked = checked, onCheckedChange = {checked=it}){
        val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
        Icon(Icons.Filled.Favorite, contentDescription = "Like", tint = tint)
    }

}
@Preview
@Composable
fun prevViewupload() {

    ViewUploadsScreen(rememberNavController())

}