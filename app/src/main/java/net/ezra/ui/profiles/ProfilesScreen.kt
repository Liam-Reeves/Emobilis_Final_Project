package net.ezra.ui.profiles

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun ProfilesScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.mayacaregiver),
            contentDescription = "Profile Image",
            modifier = Modifier.fillMaxSize()
        )
    }
    Spacer(modifier = Modifier.height(3.dp))



    LazyColumn(

        modifier = Modifier
            .background(Color.White)
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))

    ) {
                    item {
                        Row {
                            Text(   text = "Arya Stark",
                                    textAlign = TextAlign.Left,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(start = 6.dp)
                                )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Row {
                            Text(   text ="25 Years",
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
                                    Text(
                                        text = "About Arya",
                                        fontWeight = FontWeight.ExtraBold,
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        modifier = Modifier.padding(start = 6.dp)
                                    )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Row {
                            Text(text = "Lorem ipsum dolor sit amet. Qui veniam aspernatur 33 amet dolor qui impedit accusamus et laborum nulla sed pariatur asperiores aut eaque assumenda aut eveniet debitis. A placeat rerum qui enim illo id rerum exercitationem 33 magnam accusantium eos sunt voluptate sit voluptate natus. Id voluptatem eligendi qui voluptatem ducimus sit cupiditate esse sit galisum pariatur.\n" +
                                    "\n" +
                                    "Et quae aspernatur et ipsam molestiae et aliquid cumque sed eaque mollitia et sunt enim. Et autem deleniti aut obcaecati nisi sed laudantium minus?\n" +
                                    "\n" +
                                    "Ut aspernatur omnis vel inventore incidunt ut aperiam voluptate ut voluptatem quas. Qui minus voluptatibus et suscipit perferendis ut voluptates voluptates ut atque necessitatibus eos neque nihil.")
                        }
                        Spacer(modifier = Modifier.height(3.dp))

                        Row {
                            Text(
                                text = "Working Preferences",
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(start = 6.dp)
                                )



                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Card(
                                colors = CardDefaults.cardColors(Color(0xff87CEEB)),
                                elevation = CardDefaults.cardElevation(5.dp),
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    text = "Work Hours = 8 AM - 5 PM",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,)
                            }
                            Spacer(modifier = Modifier.width(3.dp))

                            Card(
                                colors = CardDefaults.cardColors(Color(0xffF9F26C )),
                                elevation = CardDefaults.cardElevation(5.dp),
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    text = "Can ably take care  of young children",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 15.sp,)
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Card(
                                colors = CardDefaults.cardColors(Color(0xff6CF979  )),
                                elevation = CardDefaults.cardElevation(5.dp),
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    text = "Expert in preparing African Dishes",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 15.sp,)
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Card(
                                colors = CardDefaults.cardColors(Color(0xffF9726C  )),
                                elevation = CardDefaults.cardElevation(5.dp),
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Text(
                                    text = "Expert in managing laundry",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,)
                            }

                            }
                            Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {

                        },
                            modifier = Modifier
                                .size(width = 200.dp, height = 200.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xff87CEEB))

                            ) {
                            Text(
                                text = "Connect with Arya",
                                )

                        }

                        }
                }

            }






























@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    ProfilesScreen(rememberNavController())
}