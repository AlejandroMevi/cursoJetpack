package com.example.mycoursecompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimtionSimple() {
    Column {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }
        var realColor = if (firstColor) Color.Red else Color.Yellow
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor })

        Spacer(modifier = Modifier.size(200.dp))

        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Yellow)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondColor = !secondColor })

        Spacer(modifier = Modifier.size(200.dp))
    }
}

@Composable
fun ColorAnimation() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }

    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })

}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = {
            if (!smallSize) {
            }
        }
    )
    Box(modifier = Modifier
        .size(100.dp)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })
}

@Composable
fun VsibilityAnimation() {

    var isVisible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text("Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }

    }
}

@Composable
fun CrossfadeExampleAnimation() {
    var myComponentType: ComponentTyoe by remember { mutableStateOf(ComponentTyoe.Text) }


    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandome() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType, label = "") { myComponentType ->
            when (myComponentType) {
                ComponentTyoe.Image -> Icon(Icons.Default.Send, contentDescription = "")
                ComponentTyoe.Text -> Text("SOY UN COMPONENTE")
                ComponentTyoe.Box -> Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Red)
                )

                ComponentTyoe.Error -> Text(text = "Error")
            }
        }

    }
}

fun getComponentTypeRandome(): ComponentTyoe {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentTyoe.Image
        1 -> ComponentTyoe.Text
        2 -> ComponentTyoe.Box
        else -> ComponentTyoe.Error
    }
}

enum class ComponentTyoe() {
    Image, Text, Box, Error
}