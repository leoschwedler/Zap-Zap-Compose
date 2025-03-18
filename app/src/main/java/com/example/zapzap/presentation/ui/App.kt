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
import com.example.zapzap.model.BottomNavItem

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
fun App() {
    val itemsBottomBar = listOf(
        BottomNavItem.Chats,
        BottomNavItem.Updates,
        BottomNavItem.Communities,
        BottomNavItem.Calls,
    )

    var selectedItem by remember { mutableStateOf(itemsBottomBar.first()) }
    val pagerState = rememberPagerState { itemsBottomBar.size }

    LaunchedEffect(selectedItem) {
        pagerState.animateScrollToPage(itemsBottomBar.indexOf(selectedItem))
    }

    LaunchedEffect(pagerState.targetPage) {
        selectedItem = itemsBottomBar[pagerState.targetPage]
    }

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
            Text(text = "ZapZap")
        }, actions = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null)
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
        })
    },
        bottomBar = {
            BottomAppBar {
                itemsBottomBar.forEach { NavItem ->
                    NavigationBarItem(
                        selected = selectedItem == NavItem,
                        onClick = { selectedItem = NavItem },
                        icon = {
                            Icon(imageVector = NavItem.icon, contentDescription = null)
                        },
                        label = { Text(NavItem.label) }

                    )
                }
            }
        }) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(innerPadding)
        ) { page ->
            val item = itemsBottomBar[page]
            when (item) {
                BottomNavItem.Calls -> CallScren()
                BottomNavItem.Chats -> ChatsScreen()
                BottomNavItem.Communities -> CommunitiesScreen()
                BottomNavItem.Updates -> UpdatesScren()
            }
        }
    }
}
