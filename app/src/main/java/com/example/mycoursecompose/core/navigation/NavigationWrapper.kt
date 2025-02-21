package com.example.mycoursecompose.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mycoursecompose.core.type.createNavTyppe
import com.example.mycoursecompose.core.type.settingsInfoType
import com.example.mycoursecompose.newnavigation.DetailScreen
import com.example.mycoursecompose.newnavigation.HomeScreen
import com.example.mycoursecompose.newnavigation.LoginScreen
import com.example.mycoursecompose.newnavigation.SettingsScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen { navController.navigate(Home) }
        }

        composable<Home> {
            HomeScreen { name -> navController.navigate(Detail(name = name)) }
        }
        composable<Detail> { backStackEntry ->
            val detail = backStackEntry.toRoute<Detail>()
            DetailScreen(
                detail.name,
                navitateBack = { navController.navigateUp() },
                navitateToSettings = {navController.navigate(Settings(it))})

            /*{
                limpiar todas las vistas
                navController.navigate(Login) {
                    popUpTo<Login> { inclusive = true }
                }

             } */
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavTyppe<SettingsInfo>())) { backStackEntry ->
            val settings: Settings = backStackEntry.toRoute()
            SettingsScreen(settings.info)
        }
    }
}