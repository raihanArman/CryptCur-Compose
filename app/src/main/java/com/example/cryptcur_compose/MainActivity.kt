package com.example.cryptcur_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.cryptcur_compose.presentation.Screen
import com.example.cryptcur_compose.presentation.coin_detail.CoinDetailScreen
import com.example.cryptcur_compose.presentation.coin_list.CoinListScreen
import com.example.cryptcur_compose.presentation.ui.theme.CryptCurComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptCurComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}",
//                            arguments = listOf(navArgument("coinId"){
//                                type = NavType.StringType
//                            })
                        ){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
