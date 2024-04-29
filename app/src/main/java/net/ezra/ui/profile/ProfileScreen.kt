package net.ezra.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navHostController: NavHostController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Profile Section")
                },
                navigationIcon = {
                    IconButton(onClick = { })
                    {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription ="Account",
                            )


                    }
                },
                actions = {
                    IconButton(onClick = { })
                    {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription ="Add",
                        )


                    }

                }


                )
        }
    ) {

    }

}























@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    ProfileScreen(rememberNavController())
}