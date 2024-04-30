package net.ezra.ui.AppBar

import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = "Yaya Kenya",
                color = Color.Black,
                )

            },
        backgroundColor = Color.Green,
        contentColor = Color.Black,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription ="Toggle Drawer"
                )

            }) {

            }
        }

    )

}