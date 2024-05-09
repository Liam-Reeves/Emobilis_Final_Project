package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.SplashScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignupScreen
import net.ezra.ui.authDialog.DialogScreen
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.dashboard.DashboardScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.locating.LocationScreen
import net.ezra.ui.products.ProductsScreen
import net.ezra.ui.profiles.ProfilesScreen
import net.ezra.ui.registration.RegistrationScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }


        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }

        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }


        composable(ROUTE_PRODUCTS) {
            ProductsScreen(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_REGISTRATION) {
            RegistrationScreen(navController )
        }

        composable(ROUTE_PROFILES) {
            ProfilesScreen(navController )
        }

        composable(ROUTE_DIALOG) {
            DialogScreen(navController)
        }

        composable(ROUTE_LOCATION) {
           LocationScreen(navController)
        }



































    }
}