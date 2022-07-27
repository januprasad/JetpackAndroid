package com.jk.navigation_compose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.flow.collectLatest

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Feed.route) {
        composable(route = Screen.Feed.route) {
            FeedScreen(onNavigate = navController::navigate)
        }

        composable(
            route = Screen.Adopt.route,
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = it.arguments?.getString("name") ?: return@composable
            AdoptionScreen(
                name = name,
                onNavigateUp = navController::navigateUp
            )
        }
    }
}

@Composable
fun FeedScreen(
    onNavigate: (String) -> Unit,
    viewModel: DogViewModel = viewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.OnSubmit.collectLatest { name ->
            onNavigate("adopt/$name")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val error = viewModel.puppyName.value.error

        TextField(
            value = viewModel.puppyName.value.text,
            onValueChange = viewModel::onPuppyNameEnter,
            modifier = Modifier.fillMaxWidth(),
            isError = error != null,
            trailingIcon = {
                if (error != null) {
                    Icon(
                        Icons.Default.Info,
                        viewModel.puppyName.value.error,
                        tint = MaterialTheme.colors.error
                    )
                }
            },
            placeholder = {
                Text(text = "Enter a puppy name")
            }
        )
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Button(onClick = viewModel::onSubmitText) {
            Text(text = "Adopt The Puppy")
        }
    }
}

@Composable
fun AdoptionScreen(
    name: String,
    onNavigateUp: () -> Unit = {}
) {
    BackHandler {
        onNavigateUp()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(name)
    }
}
