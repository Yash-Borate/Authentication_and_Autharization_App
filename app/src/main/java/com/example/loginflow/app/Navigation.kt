package com.example.loginflow.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginflow.Screens.LoginScreen
import com.example.loginflow.Screens.SignUpScreen

@Composable
fun Navigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = SignUp){
        composable(SignUp){
        SignUpScreen(navHostController)
        }
        composable(Login){
            LoginScreen(navHostController)
        }
    }
}
const val SignUp = "SignUp_Screen"
const val Login = "Login_Screen"