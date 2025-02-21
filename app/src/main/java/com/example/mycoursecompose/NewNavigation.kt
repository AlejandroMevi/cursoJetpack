package com.example.mycoursecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mycoursecompose.core.navigation.NavigationWrapper
import com.example.mycoursecompose.ui.theme.MyCourseComposeTheme

class NewNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCourseComposeTheme {
                NavigationWrapper()
            }
        }
    }
}

