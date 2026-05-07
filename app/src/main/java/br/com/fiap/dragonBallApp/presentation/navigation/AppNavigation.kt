package br.com.fiap.dragonBallApp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.dragonBallApp.presentation.character.detail.CharacterDetailScreen
import br.com.fiap.dragonBallApp.presentation.character.list.CharacterListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.CHARACTER_LIST
    ) {
        composable(AppRoutes.CHARACTER_LIST) {
            CharacterListScreen()
        }

        composable(
            route = AppRoutes.CHARACTER_DETAIL,
            arguments = listOf(
                navArgument("characterNumber") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val characterNumber = backStackEntry.arguments?.getInt("characterNumber") ?: 1

            CharacterDetailScreen(
                characterNumber = characterNumber,
                onBackClick = { navController.popBackStack() })
        }
    }

}