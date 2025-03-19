package com.example.zapzap.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zapzap.model.ScreenItem

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
fun App() {
    val screens = listOf(
        ScreenItem.Chats,
        ScreenItem.Updates,
        ScreenItem.Communities,
        ScreenItem.Calls,
    )

    var currentScreen by remember { mutableStateOf(screens.first()) }
    val pagerState = rememberPagerState { screens.size }

    LaunchedEffect(currentScreen) {
        pagerState.animateScrollToPage(screens.indexOf(currentScreen))
    }

    LaunchedEffect(pagerState.targetPage) {
        currentScreen = screens[pagerState.targetPage]
    }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
            Text(text = currentScreen.topAppBarItem.title)
        }, actions = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {
               currentScreen.topAppBarItem.icons.forEach { icon ->
                   Icon(imageVector = icon, contentDescription = null)
               }
            }
        })
    },
        bottomBar = {
            BottomAppBar {
                screens.forEach { NavItem ->
                    NavigationBarItem(
                        selected = currentScreen == NavItem,
                        onClick = { currentScreen = NavItem },
                        icon = {
                            Icon(imageVector = NavItem.bottomAppBarItem.icons, contentDescription = null)
                        },
                        label = { Text(NavItem.bottomAppBarItem.label) }

                    )
                }
            }
        }) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(innerPadding)
        ) { page ->
            val item = screens[page]
            when (item) {
                ScreenItem.Calls -> CallScren()
                ScreenItem.Chats -> ChatsScreen()
                ScreenItem.Communities -> CommunitiesScreen()
                ScreenItem.Updates -> UpdatesScren()
            }
        }
    }
}
