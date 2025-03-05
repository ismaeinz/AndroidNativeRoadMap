package com.example.hilt.app2.ui

import androidx.compose.ui.graphics.Color


data class AppState(
    val navigation: Navigation
) {
    data class Navigation(
        val navItems: List<Page>,
        val selectedPage: Page
    ) {
        data class Page(val title: String, val color: Color)
    }

    companion object {
        fun initial(): AppState {
            val pages = buildList {
                add(Navigation.Page("Page 1", Color.Red))
                add(Navigation.Page("Page 2", Color.Green))
                add(Navigation.Page("Page 3", Color.Blue))
            }
            return AppState(
                navigation = Navigation(
                    navItems = pages,
                    selectedPage = pages[0]
                )
            )
        }
    }
}