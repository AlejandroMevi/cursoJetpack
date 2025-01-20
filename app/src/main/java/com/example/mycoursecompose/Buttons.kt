package com.example.mycoursecompose

import android.widget.Space
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyButton() {
    Button(onClick = {}) {
        Text(text = "Hola")
    }
}

@Composable
fun MyButton2() {
    Button(
        onClick = {},
        enabled = false,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Blue
        )
    ) {
        Text(text = "Holiwi")
    }
}

@Composable
fun MyFilledTonalButton() {
    FilledTonalButton(onClick = {}) {
        Text(text = "Holiwi")
    }
}

@Composable
fun MyElevatedButton() {
    ElevatedButton(onClick = {}) {
        Text(text = "Holiwi")
    }
}

@Preview
@Composable
fun MyFAB() {
    FloatingActionButton(onClick = {}, containerColor = Color.Red) {
        Icon(Icons.Filled.Favorite, "Floating action button")
    }
}

@Preview
@Composable
fun MysmallFAB() {
    SmallFloatingActionButton(onClick = {}, containerColor = Color.Red) {
        Icon(Icons.Filled.Favorite, "Floating action button")
    }
}

@Preview
@Composable
fun MyAllFAB() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(24.dp)) {
        FloatingActionButton(onClick = {}, containerColor = Color.Red) {
            Icon(Icons.Filled.Favorite, "Floating action button")
        }

        Spacer(modifier = Modifier.height(8.dp))

        SmallFloatingActionButton(onClick = {}, containerColor = Color.Yellow) {
            Icon(Icons.Filled.Favorite, "Floating action button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        LargeFloatingActionButton(onClick = {}, containerColor = Color.Red) {
            Icon(Icons.Filled.Favorite, "Floating action button")
        }
        Spacer(modifier = Modifier.height(8.dp))

        ExtendedFloatingActionButton(
            onClick = { println("Hello") },
            text = { Text(text = "Extended FAB") },
            icon = { Icon(Icons.Filled.Favorite, "Floating action button")})
    }
}