package com.example.jumboapp.navigations

import BookshelfScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jumboapp.ui.theme.screens.calculator.CalculatorScreen
import com.example.jumboapp.ui.theme.screens.home.HomeScreen
import com.example.jumboapp.ui.theme.screens.music.MusicScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_BOOKSHELF) {
            BookshelfScreen(navController = navController)
        }
        composable(ROUTE_CALCULATOR) {
            CalculatorScreen(navController =  navController)
        }
        composable(ROUTE_MUSIC) {
            MusicScreen(navController = navController,)
        }
        composable(ROUTE_HOME) {
            HomeScreen(navController = navController)
        }

    }
}


