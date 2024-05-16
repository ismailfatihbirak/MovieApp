package com.example.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.presentation.detail.DetailScreen
import com.example.movieapp.presentation.home.HomeScreen
import com.example.movieapp.presentation.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenTransations()
                }
            }
        }
    }
}

@Composable
fun ScreenTransations() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { backStackEntry ->
            HomeScreen(navController = navController)
        }
        composable("detail/{movie_id}",
            arguments = listOf(
                navArgument("movie_id") { type = NavType.StringType }
            )) { backStackEntry ->
            val movie_id = backStackEntry.arguments!!.getString("movie_id")
            DetailScreen(movie_id!!)
        }

    }
}
