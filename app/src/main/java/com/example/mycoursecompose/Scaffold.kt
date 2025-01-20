package com.example.mycoursecompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                MyDrawer { coroutineScope.launch { drawerState.close() } }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    onClickIcon = { coroutineScope.launch { snackBarHostState.showSnackbar("Has pulsado $it") } },
                    onMenuClick = { coroutineScope.launch { drawerState.open() } }
                )
            },
            snackbarHost = { SnackbarHost(snackBarHostState) },
            bottomBar = {
                MyBottomNavigation(
                    selectedItem,
                    onItemSelected = { selectedItem = it })
            },
            floatingActionButtonPosition = FabPosition.Center,
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (selectedItem) {
                    0 -> Text("Home Screen", color = Color.White)
                    1 -> Text("Search Screen", color = Color.White)
                    2 -> Text("Profile Screen", color = Color.White)
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Mi primera toolbar") },
        colors = TopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            actionIconContentColor = Color.Blue,
            scrolledContainerColor = Color.Green,
            navigationIconContentColor = Color.Cyan
        ),
        navigationIcon = {
            IconButton(onClick = { onMenuClick() }) {
                Icon(Icons.Default.Menu, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Busqueda") }) {
                Icon(Icons.Default.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Favorito") }) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "favorito")
            }
        }
    )
}

@Composable
fun MyBottomNavigation(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    val items = listOf("Home", "Search", "Profile")
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.LightGray
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    when (index) {
                        0 -> Icon(Icons.Default.Home, contentDescription = null)
                        1 -> Icon(Icons.Default.Search, contentDescription = null)
                        2 -> Icon(Icons.Default.Person, contentDescription = null)
                    }
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Magenta,
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color.Magenta,
                    unselectedTextColor = Color.Black
                )
            )
        }
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(onClick = {}, containerColor = Color.Yellow) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
    }
}

@Composable
fun MyDrawer(onItemSelected: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Opción 1", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected() })
        Text("Opción 2", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected() })
        Text("Opción 3", modifier = Modifier
            .padding(8.dp)
            .clickable { onItemSelected() })
    }

}