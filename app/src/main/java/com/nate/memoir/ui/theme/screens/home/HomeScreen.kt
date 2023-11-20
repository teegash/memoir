package com.nate.memoir.ui.theme.screens.home

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import com.nate.memoir.data.Feature
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nate.memoir.R
import com.nate.memoir.data.productviewmodel
import com.nate.memoir.navigation.ROUTE_ADD_PRODUCT
import com.nate.memoir.navigation.ROUTE_CLOUD_SCREEN
import com.nate.memoir.navigation.ROUTE_HOME
import com.nate.memoir.navigation.ROUTE_LOGIN
import com.nate.memoir.navigation.ROUTE_REGISTER
import com.nate.memoir.navigation.ROUTE_VIEW_PRODUCT
import com.nate.memoir.navigation.ROUTE_VIEW_UPLOAD
import com.nate.memoir.navigation.standardQuadFromTo
import com.nate.memoir.ui.theme.Beige1
import com.nate.memoir.ui.theme.Beige2
import com.nate.memoir.ui.theme.Beige3
import com.nate.memoir.ui.theme.BlueViolet1
import com.nate.memoir.ui.theme.BlueViolet2
import com.nate.memoir.ui.theme.BlueViolet3
import com.nate.memoir.ui.theme.ButtonBlue
import com.nate.memoir.ui.theme.LightBlue
import com.nate.memoir.ui.theme.LightGreen1
import com.nate.memoir.ui.theme.LightGreen2
import com.nate.memoir.ui.theme.LightGreen3
import com.nate.memoir.ui.theme.OrangeYellow1
import com.nate.memoir.ui.theme.OrangeYellow2
import com.nate.memoir.ui.theme.OrangeYellow3
import com.nate.memoir.ui.theme.TextWhite

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var context= LocalContext.current
    var productdata= productviewmodel(navController,context)


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(18.dp))
        Image(
            painter = painterResource(R.drawable.mainlog),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(55.dp)
                .width(150.dp)
        )

        AnimatedBorderCard (modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp),
            shape = RoundedCornerShape(8.dp),
            borderWidth = 2.dp,
            gradient = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan))) {

            Column (modifier= Modifier.padding(all=20.dp)){
                Text(
                    fontSize = MaterialTheme.typography.displaySmall.fontSize,
                    fontWeight = FontWeight.Bold,
                    text = "Welcome"
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Save your day to day life and important moments in Memoir. Memoir uses the latest technology on Google Firebase to make sure that your photos are retrievable anytime, anywhere from the internet. All and more for FREE!!",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize)


            }
        }




        FeatureSection(
            features = listOf(
                Feature(
                    title = "+ Memoir",
                    R.drawable.baseline_add_a_photo_24,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3,
                ),
                Feature(
                    title = "Memoirs",
                    R.drawable.photomemoir_24,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                ),
                Feature(
                    title = "Cloud",
                    R.drawable.outline_cloud_upload_24,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3,
                ),
                Feature(
                    title = "Profile",
                    R.drawable.editprifle,
                    Beige1,
                    Beige2,
                    Beige3
                )
            ), navController = navController
        )
    
        
//        Spacer(modifier = Modifier.height(30.dp))
//
//        Button(onClick = {
//            navController.navigate(ROUTE_LOGIN)
//        }, elevation = ButtonDefaults.buttonElevation(
//            defaultElevation = 10.dp,
//            pressedElevation = 6.dp
//        ),
//            shape = RoundedCornerShape(topStart = 15.dp, bottomEnd = 17.dp),
//
//            border = BorderStroke(2.dp, Color.LightGray),
//
//            colors = ButtonDefaults.buttonColors(
//                contentColor = Color.White
//            )
//
//
//        ) {
//            Text(text = "Log out   ", color = Color.White)
//            Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = null)
//
//        }
    }

}


@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<Feature>, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it]){
                    when (it) {
                        0 -> navController.navigate(ROUTE_ADD_PRODUCT)
                        1 -> navController.navigate(ROUTE_VIEW_UPLOAD)
                        2 -> navController.navigate(ROUTE_CLOUD_SCREEN)
                        3 -> navController.navigate(ROUTE_REGISTER)
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature,
    onClick: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Go",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 2.dp,
    gradient: Brush = Brush.sweepGradient(listOf(Color.Gray, Color.White)),
    animationDuration: Int = 10000,
    onCardClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Color Animation")
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Infinite Colors"
    )

    Surface(
        modifier = modifier
            .clip(shape)
            .clickable { onCardClick() },
        shape = shape
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(borderWidth)
                .drawWithContent {
                    rotate(degrees = degrees) {
                        drawCircle(
                            brush = gradient,
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                },
            color = MaterialTheme.colorScheme.surface,
            shape = shape
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun Homepreview() {
    HomeScreen(rememberNavController())
}