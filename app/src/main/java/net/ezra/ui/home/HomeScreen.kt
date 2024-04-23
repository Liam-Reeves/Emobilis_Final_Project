package net.ezra.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import net.ezra.R



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {



    var imageVisible by remember {mutableStateOf(false) }
        LaunchedEffect(Unit) {
            delay(2000)
            imageVisible = true

        }
    Row(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row {
            if (imageVisible){
                Image(painter = painterResource(id = R.drawable.child),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .clip(RoundedCornerShape(50.dp))

                    )
            } else{
                Text(text = "Powered by Reeves",
                    modifier =Modifier
                        .padding(16.dp)
                )
            }
        }

    }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ){

            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.Black)

            ) {

                    Card(
                        colors = CardDefaults.cardColors(Color.Yellow),
                        elevation =CardDefaults.cardElevation(10.dp),
                        modifier = Modifier
                            .size(width = 500.dp, height = 100.dp)
                    ){
                        Text(
                            text = "Welcome to Yaya Kenya",
                            color = Color.Black,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(40.dp)
                            )


                }

            }



        }



@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}

