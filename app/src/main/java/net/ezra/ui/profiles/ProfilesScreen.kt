package net.ezra.ui.profiles

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import net.ezra.ui.dashboard.item
import net.ezra.ui.registration.RegistrationScreen
import net.ezra.R







@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfilesScreen(navController: NavHostController, profile: UserProfile){



    LazyColumn() {
                    item {
                        Row {
                            Text(   text = profile.name,
                                    textAlign = TextAlign.Left,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(start = 6.dp)

                                )


                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Row {
                            Text(   text = profile.age.toString(),
                                    textAlign = TextAlign.Left,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 13.sp,
                                    color = Color(0xff87CEEB),
                                    modifier = Modifier.padding(start = 6.dp)

                                )
                        }
                        Spacer(modifier = Modifier.height(3.dp))

                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.experience),
                                contentDescription = "Experience",
                                modifier = Modifier.scale(1.5f)
                            )
                            Spacer(modifier = Modifier.width(2.dp))

                            Text(   "5 Years",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = Color.Black,
                                )
                        }
                        Row {

                        }
                    }
                }

            }






























@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    ProfilesScreen(rememberNavController())
}