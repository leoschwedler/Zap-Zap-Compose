package com.example.zapzap.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val label: String,
    val icon: ImageVector
) {
    data object Chats : BottomNavItem("Chats", Icons.Default.Chat)
    data object Updates : BottomNavItem("Updates", Icons.Default.Notifications)
    data object Communities : BottomNavItem("Communities", Icons.Default.MoreVert)
    data object Calls : BottomNavItem("Calls", Icons.Default.Phone)
}
