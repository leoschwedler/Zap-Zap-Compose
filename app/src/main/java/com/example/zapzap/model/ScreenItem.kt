package com.example.zapzap.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenItem(
    val topAppBarItem: TopAppBarItem,
    val bottomAppBarItem: BottomAppBarItem
) {
    data object Chats : ScreenItem(
        topAppBarItem = TopAppBarItem(
            title = "Zap Zap", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.MoreVert)),
        bottomAppBarItem = BottomAppBarItem("Chats", Icons.Default.Chat))
    data object Updates : ScreenItem(
        topAppBarItem = TopAppBarItem(
            title = "Updates", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.Search,
                Icons.Default.MoreVert,
                )
        ),
        bottomAppBarItem = BottomAppBarItem("Updates", Icons.Default.Notifications))

    data object Communities : ScreenItem(
        topAppBarItem = TopAppBarItem(
            title = "Communities", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.MoreVert)
        ),
        bottomAppBarItem = BottomAppBarItem("Communities", Icons.Default.MoreVert))
    data object Calls : ScreenItem(
        topAppBarItem = TopAppBarItem(
            title = "Calls", icons = listOf(
                Icons.Default.CameraAlt,
                Icons.Default.Search,
                Icons.Default.MoreVert,
            )
        ),
        bottomAppBarItem = BottomAppBarItem("Calls", Icons.Default.Phone))
}

data class TopAppBarItem(
    val title: String,
    val icons: List<ImageVector> = emptyList()
)

data class BottomAppBarItem(
    val label: String,
    val icons: ImageVector
)