package br.com.fiap.dragonBallApp.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.dragonBallApp.presentation.character.detail.CharacterDetailScreen
import br.com.fiap.dragonBallApp.presentation.character.list.CharacterListScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 13)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.CHARACTER_LIST
    ) {
        composable(AppRoutes.CHARACTER_LIST) {
            CharacterListScreen(onCharacterClick = { characterNumber ->
                navController.navigate(
                    AppRoutes.characterDetail(characterNumber)
                )
            })
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