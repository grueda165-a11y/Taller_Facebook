package com.gustavorueda.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gustavorueda.facebook.ui.screens.FacebookForgotPasswordScreen
import com.gustavorueda.facebook.ui.screens.FacebookLoginScreen
import com.gustavorueda.facebook.ui.screens.FacebookRegisterScreen
import com.gustavorueda.facebook.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()

            NavHost(
                navController = myNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login") {
                    FacebookLoginScreen(
                        onClickRegister = { myNavController.navigate("register") },
                        onClickIniciarSesion = { myNavController.navigate("feed") },
                        onClickForgotPassword = { myNavController.navigate("forgot_password") } // <-- Navegación agregada
                    )
                }

                composable(route = "register") {
                    FacebookRegisterScreen(
                        onClickBack = { myNavController.popBackStack() }
                    )
                }

                composable(route = "forgot_password") { // <-- Nueva ruta
                    FacebookForgotPasswordScreen(
                        onClickBack = { myNavController.popBackStack() },
                        onClickSearch = { query ->
                            // Lógica de búsqueda/envío de código o navegación
                            myNavController.popBackStack()
                        }
                    )
                }

                composable(route = "feed") {
                    FeedScreen()
                }
            }
        }
    }
}