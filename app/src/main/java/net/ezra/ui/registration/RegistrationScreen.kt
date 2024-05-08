package net.ezra.ui.registration

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.ui.dashboard.item


data class  BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount:Int? = null,
)

val items= listOf(
    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasNews = false,
    ),

    BottomNavigationItem(
        title = "Account",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        hasNews = false,
    ),

    BottomNavigationItem(
        title = "Updates",
        selectedIcon = Icons.Filled.Build,
        unselectedIcon = Icons.Outlined.Build,
        hasNews = false,
        badgeCount = 9
    ),

    BottomNavigationItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        hasNews = false,
    ),

    )

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun RegistrationScreen(navController: NavHostController){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    var selectedSecondListIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(


            ) {
                Spacer(modifier = Modifier.height(16.dp))
                item.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selectedSecondListIndex ,
                        onClick = {
                            selectedSecondListIndex = index
                            scope.launch {
                                drawerState.close()

                            }

                        },
                        icon = {
                            Icon(
                                imageVector =
                                if( index == selectedSecondListIndex) {
                                    item.selectedIcon
                                }else item.unselectedIcon,
                                contentDescription =item.title ,
                                tint = if (index == selectedItemIndex) {
                                    Color((0xffec0ac9))
                                } else Color.Unspecified
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }


                        },

                        colors = NavigationDrawerItemDefaults.colors(Color(0xff87CEEB)),
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
//



                    )

                }

            }

        },
        drawerState = drawerState
    ) {


        Scaffold(

            bottomBar = {
                NavigationBar {
                    net.ezra.ui.dashboard.items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
//                                 navController.navigate(item.title)

                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
//                                  if(item.badgeCount != null) {
//                                      Badge{
//                                          Text(
//                                              text = item.badgeCount.toString()
//                                          )
//                                      }
//                                  } else if(item.hasNews){
//                                      androidx.compose.material.Badge()
//
//                                  }

                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,

                                        contentDescription = item.title,
                                        tint = Color(0xff87CEEB)

                                    )


                                }

                            },

                            )

                    }
                }
            },

            content = @Composable {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(28.dp)
                        .background(Color.White)

                ) {
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,

                            ) {
                            Text(
                                text = "Hey, there",
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Light,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 50.dp, top = 50.dp, bottom = 2.dp)


                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "Create Account",
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                modifier = Modifier.padding(
                                    start = 50.dp,
                                    top = 2.dp,
                                    bottom = 10.dp
                                )
                            )
                            Spacer(modifier = Modifier.width(20.dp))


                        }
                        Spacer(modifier = Modifier.height(8.dp))


                        var fullName by remember {
                            mutableStateOf(TextFieldValue(""))
                        }
                        OutlinedTextField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            label = { Text(text = "Full Name") },
                            textStyle = TextStyle(Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color(0xff87CEEB),
                                )

                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color(0xff87CEEB),
                                focusedLabelColor = Color(0xff87CEEB),
                                cursorColor = Color.Black,


                                ),
                            modifier = Modifier
                                .padding(start = 70.dp, end = 70.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        var email by remember {
                            mutableStateOf(TextFieldValue(""))
                        }
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text(text = "Email Address") },
                            textStyle = TextStyle(Color.Black),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null,
                                    tint = Color(0xff87CEEB),
                                )

                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color(0xff87CEEB),
                                focusedLabelColor = Color(0xff87CEEB),
                                cursorColor = Color.Black,
                            ),
                            modifier = Modifier
                                .padding(start = 70.dp, end = 70.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        var phone by remember {
                            mutableStateOf(TextFieldValue(""))
                        }
                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text(text = "Phone Number") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Call,
                                    contentDescription = null,
                                    tint = Color(0xff87CEEB),
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color(0xff87CEEB),
                                focusedLabelColor = Color(0xff87CEEB),
                                cursorColor = Color.Black,


                                ),
                            modifier = Modifier
                                .padding(start = 70.dp, end = 70.dp)

                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        var date by remember {
                            mutableStateOf(TextFieldValue(""))
                        }
                        OutlinedTextField(
                            value = date,
                            onValueChange = { date = it },
                            label = {
                                Text(text = "D.O.B")
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = null,
                                    tint = Color(0xff87CEEB),
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color(0xff87CEEB),
                                focusedLabelColor = Color(0xff87CEEB),
                                cursorColor = Color.Black,


                                ),
                            modifier = Modifier
                                .padding(start = 70.dp, end = 70.dp)

                        )
                        Spacer(modifier = Modifier.height(10.dp))


                        var password by remember {
                            mutableStateOf(TextFieldValue(""))
                        }
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Password") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(0xff87CEEB),
                                )
                            },

                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color(0xff87CEEB),
                                focusedLabelColor = Color(0xff87CEEB),
                                cursorColor = Color.Black,
                            ),
                            modifier = Modifier
                                .padding(start = 70.dp, end = 70.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))





                        Row {
                            Text(
                                text = "By continuing you accept our Privacy Policy and Terms of Use",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(start = 50.dp)
                                )

                        }

                        Card(
                            onClick = {
                                navController.navigate(ROUTE_PRODUCTS)

                            },
                            colors = CardDefaults.cardColors(Color(0xff87CEEB)),
                            elevation = CardDefaults.cardElevation(5.dp),
                            modifier = Modifier
                                .padding(start = 50.dp, end = 50.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .size(width = 200.dp, height = 50.dp)
                        ) {
                            Text(
                                text = "Register",
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 50.dp, end = 50.dp, top = 20.dp,)
                            )

                        }


                    }
                }

            }


        )


    }


}

























@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    RegistrationScreen(rememberNavController())
}