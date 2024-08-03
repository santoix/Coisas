package com.example.coisas

sealed class Screens(val route: String){
    data object Home: Screens("Home")
    data object Note: Screens("Note")
    data object NotePage: Screens("NotePage")
    data object Settings : Screens("Settings")
}