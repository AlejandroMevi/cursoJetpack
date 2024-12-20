package com.example.mycoursecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoursecompose.ui.theme.MyCourseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCourseComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    MySuperText("Alex mevis")
                }
            }
        }
    }
}

@Preview(
    name = "PREVIEW 1 GUAY", heightDp = 50, widthDp = 200, showBackground = true,
    showSystemUi = true, device = Devices.NEXUS_5
)
@Composable
fun MyTestSuperText() {
    MySuperText("Alex Mevi")
}

@Composable
fun MySuperText(name: String) {
    Text(text = "Hola $name", modifier = Modifier
        .fillMaxSize()
        .padding(20.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCourseComposeTheme {
        Greeting("Android")
    }
}