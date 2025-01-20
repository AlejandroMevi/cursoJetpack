package com.example.mycoursecompose.model

sealed class Routes(val route: String) {
    data object Pantalla1 : Routes("pantalla1")
    data object Pantalla2 : Routes("pantalla2")
    data object Pantalla3 : Routes("pantalla3")
    data object Pantalla4 : Routes("pantalla4/{age}") {
        fun createRoute(age: Int) = "pantalla4/$age"
    }

    data object Pantalla5 : Routes("pantalla5?name={name}") {
        fun createRoute(name: String) = "pantalla5?name=$name"
    }
}