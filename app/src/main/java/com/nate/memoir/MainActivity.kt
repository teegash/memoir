package com.nate.memoir

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.nate.memoir.navigation.AppNavHost
import com.nate.memoir.navigation.ROUTE_ADD_PRODUCT
import com.nate.memoir.navigation.ROUTE_CLOUD_SCREEN
import com.nate.memoir.navigation.ROUTE_HOME
import com.nate.memoir.navigation.ROUTE_LOGIN
import com.nate.memoir.navigation.ROUTE_REGISTER
import com.nate.memoir.navigation.ROUTE_SPLASH_SCREEN
import com.nate.memoir.navigation.ROUTE_UPDATE_PRODUCT
import com.nate.memoir.navigation.ROUTE_VIEW_PRODUCT
import com.nate.memoir.navigation.ROUTE_VIEW_UPLOAD
import com.nate.memoir.ui.theme.LightBlue
import com.nate.memoir.ui.theme.LightBlueBright
import com.nate.memoir.ui.theme.MemoirTheme
import com.nate.memoir.ui.theme.screens.home.CloudDance
import com.nate.memoir.ui.theme.screens.home.HomeScreen
import com.nate.memoir.ui.theme.screens.home.SplashScreen
import com.nate.memoir.ui.theme.screens.login.LoginScreen
import com.nate.memoir.ui.theme.screens.product.AddProductsScreen
import com.nate.memoir.ui.theme.screens.product.UpdateProductsScreen
import com.nate.memoir.ui.theme.screens.product.ViewProductsScreen
import com.nate.memoir.ui.theme.screens.product.ViewUploadsScreen
import com.nate.memoir.ui.theme.screens.register.RegisterScreen
import okhttp3.Route


data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

//class MainActivity : ComponentActivity() {
//    @OptIn(ExperimentalMaterial3Api::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MemoirTheme {
//
//                val navController = rememberNavController()
//
//                val items = listOf(
//                    BottomNavigationItem(
//                        title = "Home",
//                        route = ROUTE_HOME ,
//                        selectedIcon = Icons.Filled.Home,
//                        unselectedIcon = Icons.Outlined.Home,
//                    ),
//                    BottomNavigationItem(
//                        title = "Add Memoir",
//                        route = ROUTE_ADD_PRODUCT ,
//                        selectedIcon = Icons.Filled.AddCircle,
//                        unselectedIcon = Icons.Outlined.Add,
//                    ),
//                    BottomNavigationItem(
//                        title = "Memoirs",
//                        route = ROUTE_VIEW_UPLOAD ,
//                        selectedIcon = Icons.Filled.Menu,
//                        unselectedIcon = Icons.Outlined.Menu
//                    ),
//                    BottomNavigationItem(
//                        title = "Cloud",
//                        route= ROUTE_CLOUD_SCREEN,
//                        selectedIcon = Icons.Filled.PlayArrow,
//                        unselectedIcon = Icons.Outlined.PlayArrow
//                    ),
//                )
//                var selectedItemIndex by rememberSaveable {
//                    mutableStateOf(0)
//                }
//
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Scaffold(
//                        bottomBar = {
//                            NavigationBar {
//                                items.forEachIndexed { index, item ->
//                                    NavigationBarItem(
//                                        selected = selectedItemIndex == index,
//                                        onClick = {
//                                            selectedItemIndex = index
//                                            navController.navigate(item.route)
//                                        },
//                                        label = {
//                                            Text(text = item.title)
//                                        },
//                                        alwaysShowLabel = true,
//                                        icon =
//                                            {
//                                                Icon(
//                                                    imageVector = if (index == selectedItemIndex) {
//                                                        item.selectedIcon
//                                                    } else item.unselectedIcon,
//                                                    contentDescription = item.title
//                                                )
//                                            }
//                                    )
//                                }
//                            }
//                        }
//                    )
//                    { paddingValues ->
//                        Box(modifier = Modifier.padding(paddingValues)) {
//                            AppNavHost()
//                        }
//
//                    }
//                }
//            }
//        }
//    }
//}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            MemoirTheme {
                val navController = rememberNavController()
                val backstackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backstackEntry?.destination?.route

                val bottomBarVisibility = remember { mutableStateOf(true) }

// Listen for navigation events to hide or show the Bottom Navigation Bar
                navController.addOnDestinationChangedListener { _, destination, _ ->
                    bottomBarVisibility.value = when (destination.route) {
                        ROUTE_HOME, ROUTE_VIEW_UPLOAD, ROUTE_CLOUD_SCREEN, ROUTE_ADD_PRODUCT -> true // Screens where the Bottom Navigation Bar should be visible
                        else -> false // All other screens
                    }
                }



                val items = listOf(
                    BottomNavigationItem("Home", ROUTE_HOME, Icons.Filled.Home, Icons.Outlined.Home),
                    BottomNavigationItem("Add Memoir", ROUTE_ADD_PRODUCT, Icons.Filled.AddCircle, Icons.Outlined.Add),
                    BottomNavigationItem("Memoirs", ROUTE_VIEW_UPLOAD, Icons.Filled.Menu, Icons.Outlined.Menu),
                    BottomNavigationItem("Cloud", ROUTE_CLOUD_SCREEN, Icons.Filled.PlayArrow, Icons.Outlined.PlayArrow)
                )

                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

                Surface(modifier = Modifier.fillMaxSize().background(Color.Black), color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            if (bottomBarVisibility.value)
                            NavigationBar (modifier = Modifier.background(Color.DarkGray)){
                                items.forEachIndexed { index, item ->
                                    val isSelected = item.route == currentRoute
                                    NavigationBarItem(
                                        selected = isSelected,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(item.route) {
                                                launchSingleTop = true
                                            }
                                        },
                                        label = { Text(text = item.title, color = LightBlueBright) },
                                        alwaysShowLabel = true,
                                        icon = {
                                            Icon(
                                                imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                                contentDescription = item.title,
                                                tint = if (isSelected) LightBlueBright else Color.Gray
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    ) { paddingValues ->
                        Box(modifier = Modifier.padding(paddingValues)) {
                            NavHost(navController = navController, modifier=Modifier, startDestination = ROUTE_SPLASH_SCREEN ){
                                composable(ROUTE_LOGIN){
                                    LoginScreen(navController)
                                }
                                composable(ROUTE_REGISTER){
                                    RegisterScreen(navController)
                                }
                                composable(ROUTE_HOME){
                                    HomeScreen(navController)
                                }
                                composable(ROUTE_ADD_PRODUCT) {
                                    AddProductsScreen(navController)
                                }
                                composable(ROUTE_VIEW_PRODUCT){
                                    ViewProductsScreen(navController)
                                }
                                composable(ROUTE_UPDATE_PRODUCT + "/{id}"){ passedData ->
                                    UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
                                }
                                composable(ROUTE_VIEW_UPLOAD){
                                    ViewUploadsScreen(navController)
                                }
                                composable(ROUTE_SPLASH_SCREEN){
                                    SplashScreen(navController)
                                }
                                composable(ROUTE_CLOUD_SCREEN){
                                    CloudDance(navController)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}




//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MemoirTheme {
//        Greeting("Android")
//    }
//}

