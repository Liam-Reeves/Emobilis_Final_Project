package net.ezra.ui.locating

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.GoogleMap
import kotlinx.coroutines.launch
import net.ezra.ui.authDialog.DialogScreen

@Composable
fun LocationScreen(navController: NavHostController){


}









@Preview(showBackground = true)
@Composable
fun PreviewLight(){
   LocationScreen(rememberNavController())
}