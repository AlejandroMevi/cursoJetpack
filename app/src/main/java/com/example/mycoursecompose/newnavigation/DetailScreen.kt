package com.example.mycoursecompose.newnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.mycoursecompose.core.navigation.SettingsInfo

@Composable
fun DetailScreen(
    name: String,
    navitateToSettings: (SettingsInfo) -> Unit,
    navitateBack: () -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "DETAIL SCREEN $name", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            val settingsInfo =
                SettingsInfo(name = "Ale", id = 1, darkMode = true, suscribete = true)
            navitateToSettings(settingsInfo)
        }) {
            Text(text = "Navegar a ajustes")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navitateBack() }) {
            Text(text = "Logout")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}