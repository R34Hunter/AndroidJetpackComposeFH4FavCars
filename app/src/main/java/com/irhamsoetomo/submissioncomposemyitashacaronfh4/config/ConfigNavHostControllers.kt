package com.irhamsoetomo.submissioncomposemyitashacaronfh4.config

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass.Pathing
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage.FH4CarsInformation
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage.FH4CarMainPage
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage.AboutOwnerPage
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.ui.theme.SubmissionComposeMyItashaCarOnFH4Theme

@Composable
fun ConfigNavHostController(modifier: Modifier = Modifier, configNavCon: NavHostController = rememberNavController(), ) {
    val direct by configNavCon.currentBackStackEntryAsState()
    val path = direct?.destination?.route

    Scaffold(topBar = {
        if (path == Pathing.CarsMainPage.path) {
            ConfigTopNavHostController(navController = configNavCon, modifier = modifier.padding(start = 9.dp))
        }
    }) { padding -> NavHost(navController = configNavCon, startDestination = Pathing.CarsMainPage.path, modifier = Modifier.padding(padding)) {
        composable(Pathing.CarsMainPage.path) {
            FH4CarMainPage(navigateToDetail = {
                    id -> configNavCon.navigate(Pathing.CarsInformationPage.getCarsListIdentifier(id))
            })
        }
        composable(route = Pathing.CarsInformationPage.path, arguments = listOf(navArgument("id") { type = NavType.LongType })) {
            val getIdentifierList = it.arguments?.getLong("id") ?: -1L
            FH4CarsInformation(id = getIdentifierList, navigateBack = {
                    configNavCon.navigateUp()
            })
        }
        composable(route = Pathing.AboutOwnerPage.path) { AboutOwnerPage(setOnClickListener = { configNavCon.navigateUp() }) }
    }}
}

@Composable
fun ConfigTopNavHostController(navController: NavHostController, modifier: Modifier) {
    TopAppBar(backgroundColor = Color.Magenta) {
        Box(modifier = modifier.fillMaxSize().weight(0.9f), contentAlignment = Alignment.CenterStart) {
            Text(text = "Top 10 Fav Cars (FH 4)", fontSize = 24.sp, color = Color.White,)
        }
        IconButton(onClick = {
            navController.navigate(Pathing.AboutOwnerPage.path) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        ) {
            Icon(imageVector = Icons.Default.Info, contentDescription = "infoAboutOwnerPage", tint = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigNavHostControllerPreview() = SubmissionComposeMyItashaCarOnFH4Theme { ConfigNavHostController() }