package com.example.contactme

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactme.entitiy.User
import com.example.contactme.presentation.contact_detail.ContactDetail
import com.example.contactme.presentation.contact_register.ContactRegister
import com.example.contactme.presentation.home.Home
import com.google.gson.Gson

@Composable
fun NavigationHelper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            Home(navController = navController)
        }
        composable("userRegister"){
            ContactRegister()
        }
        composable("userDetail/{user}",arguments = listOf(
            navArgument("user"){ type = NavType.StringType }
        )){
            val json = it.arguments?.getString("user")
            val user = Gson().fromJson(json,User::class.java)
            ContactDetail(user)
        }
    }
}