package com.jk.navigation_compose

sealed class Screen(val route: String) {
    object Feed : Screen("feed")
    object Adopt : Screen("adopt/{name}")
}
