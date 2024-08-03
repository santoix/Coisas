package com.example.coisas

import NotePage
import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coisas.ui.theme.BlackL
import com.example.coisas.ui.theme.CoisasTheme
import com.example.coisas.ui.theme.GoldL
import com.example.coisas.ui.theme.RedL
import com.example.coisas.ui.theme.testeroboto
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoisasTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CoisasNavDrawer()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoisasNavDrawer() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val image = painterResource(R.drawable.gettyimages_1206008726_530271_rhxjqd_removebg_preview)

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(GoldL)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(text = "")
                    Image(
                        painter = image,
                        contentDescription = "Background Image",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = BlackL, fontFamily = testeroboto, fontSize = 30.sp) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = BlackL) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Home.route) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Note", color = BlackL, fontFamily = testeroboto, fontSize = 30.sp) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "AddNote", tint = BlackL) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.NotePage.route) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = BlackL, fontFamily = testeroboto, fontSize = 30.sp) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = BlackL) },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Settings.route) {
                            popUpTo(0)
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Coisas", fontSize = 50.sp, fontFamily = testeroboto) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GoldL,
                        titleContentColor = BlackL,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Rounded.Menu, contentDescription = "MenuButton")
                        }
                    }
                )
            },
            bottomBar = {

                // teste3
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // teste 5
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screens.Home.route,
                    Modifier.fillMaxSize()
                ) {
                    composable(Screens.Home.route) { Home() }
                    composable(Screens.NotePage.route) { NotePage() }
                    composable(Screens.Settings.route) { Settings() }
                }
            }
        }
    }
}

