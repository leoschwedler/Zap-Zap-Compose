package com.example.zapzap.commom.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ItemList(modifier: Modifier = Modifier) {
    Row(modifier = modifier.background(Color.Gray, shape = MaterialTheme.shapes.large).padding(16.dp), verticalAlignment = Alignment.CenterVertically, ) {
        AsyncImage(
            model = "https://pm1.aminoapps.com/6973/6f831802367c00e9de7a3c36bae819ae90bdb78fr1-1035-1524v2_hq.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Name", fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = "Message", color = Color.Black)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = "11:26:AM", fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(Modifier.height(4.dp))
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}