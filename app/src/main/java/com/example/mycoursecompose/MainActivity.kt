package com.example.mycoursecompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoursecompose.ui.theme.MyCourseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCourseComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyRow()
                }
            }
        }
    }
}

@Composable
fun MyRow() {
    /*
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("Ejemplo1")
        Text("Ejemplo1")
        Text("Ejemplo1")
    }
     */
    Row(modifier = Modifier.fillMaxSize().horizontalScroll(rememberScrollState())) {
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
        Text("Ejemplo1", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
    }
}


@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Cyan)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCourseComposeTheme {
        MyBox()
    }
}

@Preview(showBackground = true, name = "Elements create")
@Composable
fun MyColumPreview() {
    MyCourseComposeTheme {
            MyRow()
    }
}