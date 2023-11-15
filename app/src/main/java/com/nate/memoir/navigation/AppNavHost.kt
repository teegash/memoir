package com.nate.memoir.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.nate.memoir.ui.theme.screens.home.CloudDance
//import com.nate.memoir.ui.theme.screens.home.HomeScreen
//import com.nate.memoir.ui.theme.screens.home.SplashScreen
//import com.nate.memoir.ui.theme.screens.login.LoginScreen
//import com.nate.memoir.ui.theme.screens.product.AddProductsScreen
//import com.nate.memoir.ui.theme.screens.product.UpdateProductsScreen
//import com.nate.memoir.ui.theme.screens.product.ViewProductsScreen
//import com.nate.memoir.ui.theme.screens.product.ViewUploadsScreen
//import com.nate.memoir.ui.theme.screens.register.RegisterScreen
//
//@Composable
//fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH_SCREEN) {
//
//    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
//        composable(ROUTE_LOGIN){
//            LoginScreen(navController)
//        }
//        composable(ROUTE_REGISTER){
//            RegisterScreen(navController)
//        }
//        composable(ROUTE_HOME){
//            HomeScreen(navController)
//        }
//        composable(ROUTE_ADD_PRODUCT) {
//            AddProductsScreen(navController)
//        }
//        composable(ROUTE_VIEW_PRODUCT){
//            ViewProductsScreen(navController)
//        }
//        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
//            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
//        }
//        composable(ROUTE_VIEW_UPLOAD){
//            ViewUploadsScreen(navController)
//        }
//        composable(ROUTE_SPLASH_SCREEN){
//            SplashScreen(navController)
//        }
//        composable(ROUTE_CLOUD_SCREEN){
//            CloudDance(navController)
//        }
//    }
//
//}