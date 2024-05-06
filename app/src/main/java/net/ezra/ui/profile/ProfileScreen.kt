package net.ezra.ui.profile

import android.annotation.SuppressLint
import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Badge
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import net.ezra.R
import net.ezra.navigation.ROUTE_PRODUCTS


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
fun ProfileScreen(navController: NavHostController){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


  Scaffold (

      bottomBar = {
          NavigationBar {
              net.ezra.ui.dashboard.items.forEachIndexed{ index, item ->
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
                                  imageVector = if(index == selectedItemIndex) {
                                      item.selectedIcon
                                  } else item.unselectedIcon,

                                  contentDescription = item.title,
                                  tint = Color(0xff87CEEB)

                              )


                          }
                                                  0xff87CEEB
                      },

                      )

              }
          }
      },

      content = @Composable{
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
                                 modifier =  Modifier.padding(start = 50.dp,  top =2.dp, bottom = 10.dp)
                            )
                     Spacer(modifier = Modifier.width(20.dp))
                     Image(
                         painter = painterResource(id = R.drawable.yaya),
                         contentDescription ="",
                         contentScale = ContentScale.Crop,
                         modifier = Modifier
                             .clip(CircleShape)
                         )

                 }
                 Spacer(modifier = Modifier.height(8.dp))

                =
                    var fullName by remember {
                    mutableStateOf( TextFieldValue(""))
                }
                    OutlinedTextField(
                        value = fullName ,
                        onValueChange = {fullName = it},
                        label = { Text(text = "Full Name")},
                        textStyle = TextStyle(Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        leadingIcon = {
                            Icon(
                                imageVector =Icons.Default.Person ,
                                contentDescription = null,
                                tint = Color.Blue,
                            )

                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedBorderColor = Color.Cyan,
                            focusedLabelColor = Color.Cyan,
                            cursorColor = Color.Black,


                            ),
                        modifier = Modifier
                            .padding(start = 70.dp, end = 70.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    var email by remember{
                        mutableStateOf(TextFieldValue(""))
                    }
                    OutlinedTextField(
                        value = email ,
                        onValueChange = {email = it},
                        label = { Text(text = "Email Address")},
                        textStyle = TextStyle(Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        leadingIcon = {
                            Icon(
                                imageVector =Icons.Default.Email ,
                                contentDescription = null,
                                tint = Color.Blue,
                            )

                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedBorderColor = Color.Cyan,
                            focusedLabelColor = Color.Cyan,
                            cursorColor = Color.Black,
                        ),
                        modifier = Modifier
                            .padding(start = 70.dp, end = 70.dp)
                            )

                    Spacer(modifier = Modifier.height(10.dp))

                    var phone by remember{
                        mutableStateOf(TextFieldValue(""))
                    }
                    OutlinedTextField(
                        value = phone ,
                        onValueChange ={phone = it},
                        label = { Text(text = "Phone Number")},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription =null,
                                tint = Color.Blue,
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedBorderColor = Color.Cyan,
                            focusedLabelColor = Color.Cyan,
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
                        value = date ,
                        onValueChange ={date = it},
                        label = {
                            Text(text = "D.O.B")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription =null,
                                tint = Color.Blue,
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedBorderColor = Color.Cyan,
                            focusedLabelColor = Color.Cyan,
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
                        onValueChange ={password = it},
                        label = { Text(text = "Password")},

                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            focusedBorderColor = Color.Cyan,
                            focusedLabelColor = Color.Cyan,
                            cursorColor = Color.Black,
                        ),
                        modifier = Modifier
                            .padding(start = 70.dp, end = 70.dp)
                        )
                    Spacer(modifier = Modifier.height(10.dp))


                    Row {
                        Text(text = "By continuing you accept our Privacy Policy and Terms of Use")

                    }

                    Card(
                        onClick = { navController.navigate(ROUTE_PRODUCTS)

                        },
                        colors = CardDefaults.cardColors(Color.Blue),
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
                                     .padding(start = 50.dp, end =50.dp, top = 20.dp, )
                                 )

                    }






                 }
             }

          }






  )






}

























@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    ProfileScreen(rememberNavController())
}