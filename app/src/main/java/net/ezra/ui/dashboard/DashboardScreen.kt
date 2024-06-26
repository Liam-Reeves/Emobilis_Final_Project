package net.ezra.ui.dashboard



import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import net.ezra.R
import net.ezra.navigation.ROUTE_REGISTRATION

data class NavigationItem (
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

val item = listOf(
    NavigationItem(
        title = "All",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,

    ),
    NavigationItem(
        title = "Urgent",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
        badgeCount = 45,


    ),
    NavigationItem(
        title = "Settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,

)

)
data class  BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon:ImageVector,
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
        title = "History",
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


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController) {

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
                                                Color((0xff87CEEB))
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
            topBar = {
                  TopAppBar(
                      title = {
                          Text(
                              text = "Yaya Kenya",
                              fontWeight = FontWeight.Bold,
                              color = Color.White,
                              )
                       },
                      navigationIcon = {
                          IconButton(onClick = {
                              scope.launch {
                                  drawerState.open()
                              }

                               }) {
                              Icon(
                                  imageVector = Icons.Default.Menu ,
                                  contentDescription = "Menu")

                          }
                      },
                      colors = TopAppBarDefaults.topAppBarColors(Color(0xff87CEEB)),
                      modifier = Modifier
                          .clip(RoundedCornerShape(40.dp))

                  )
            },


            bottomBar = {
                NavigationBar(

                ) {
                    items.forEachIndexed{ index, item ->
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
                                        if(item.badgeCount != null){
                                            Badge{
                                                Text(
                                                    text = item.badgeCount.toString()
                                                )
                                            }
                                        } else if(item.hasNews){
                                            androidx.compose.material.Badge()
                                        }

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

                            },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))

                        )

                    }
                }


            },
            content = @Composable{
                LazyColumn(
                    modifier = Modifier
                        .background(Color(0xffe4e3e3))
                        .fillMaxSize()
                ) {
                    item {
                        Column {
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,

                                ){
                                Text(
                                    "Yaya Kenya",
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(start= 20.dp,)

                                )
                                Spacer(modifier = Modifier.width(90.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.yaya),
                                    contentDescription =null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .aspectRatio(1f, matchHeightConstraintsFirst = true)
                                        .border(
                                            width = 1.dp,
                                            color = Color.LightGray,
                                            shape = CircleShape,
                                        )
                                        .padding(top = 100.dp)
                                        .size(100.dp)
                                        .clip(CircleShape)
                                        .weight(3f)
                                )


                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                "Ensure your beloved family care to us",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 20.sp,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.Black,
                                modifier = Modifier.padding(start= 20.dp)
                            )
                        }
                        LazyRow(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(10.dp)

                        ) {
                            item {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color(0xffFFB6C1))
                                        .size(width = 200.dp, height = 120.dp)

                                ){
                                    Text(
                                        text = "Child Care",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xfff5f0ee),
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))

                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color(0xffCBC3E3))
                                        .size(width = 200.dp, height = 120.dp)
                                ){
                                    Text(
                                        text = "Cooking",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xfff5f0ee),
                                    )

                                    Spacer(modifier = Modifier.width(5.dp))


                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color(0xffFFD580))
                                        .size(width = 200.dp, height = 120.dp)
                                ){
                                    Text(
                                        text = "Laundry",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xfff5f0ee),
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))



                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text ="All category",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(start= 10.dp, top = 10.dp)

                            )

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        LazyRow {
                            item {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ) {
                                    Card (
                                        colors =CardDefaults.cardColors(Color(0xffFC7EF5 )),
                                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                                        border = BorderStroke(1.dp, Color.Black),
                                        modifier = Modifier

                                            .clip(RoundedCornerShape(10.dp))
                                            .padding(
                                                start = 20.dp,
                                                bottom = 10.dp,
                                                end = 10.dp,
                                                top = 20.dp
                                            )
                                            .size(width = 100.dp, height = 150.dp)

                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.care) ,
                                            contentDescription = "Logo",
                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(
                                                    start = 5.dp,
                                                    top = 20.dp,
                                                    end = 5.dp,
                                                    bottom = 5.dp
                                                )

                                        )

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))

                                    Card (
                                        colors =CardDefaults.cardColors(Color(0xffF98888 )),
                                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                                        border = BorderStroke(1.dp, Color.Black),
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .padding(
                                                start = 20.dp,
                                                bottom = 10.dp,
                                                end = 10.dp,
                                                top = 20.dp
                                            )
                                            .size(width = 100.dp, height = 150.dp)

                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.laundry) ,
                                            contentDescription = "Logo",

                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(
                                                    start = 5.dp,
                                                    top = 20.dp,
                                                    end = 5.dp,
                                                    bottom = 5.dp
                                                )

                                        )

                                    }

                                    Spacer(modifier = Modifier.width(5.dp))

                                    Card (
                                        colors =CardDefaults.cardColors(Color(0xff889BF9 )),
                                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                                        border = BorderStroke(1.dp, Color.Black),
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .padding(
                                                start = 20.dp,
                                                bottom = 10.dp,
                                                end = 10.dp,
                                                top = 20.dp
                                            )
                                            .size(width = 100.dp, height = 150.dp)

                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.cooking) ,
                                            contentDescription = "Logo",


                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(
                                                    start = 5.dp,
                                                    top = 5.dp,
                                                    end = 5.dp,
                                                    bottom = 5.dp
                                                )

                                        )

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))

                                    Card (
                                        colors =CardDefaults.cardColors(Color(0xffAF88F9 )),
                                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                                        border = BorderStroke(1.dp, Color.Black),
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .padding(
                                                start = 20.dp,
                                                bottom = 10.dp,
                                                end = 10.dp,
                                                top = 20.dp
                                            )
                                            .size(width = 100.dp, height = 150.dp)

                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.sweep) ,
                                            contentDescription = "Logo",

                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(
                                                    start = 5.dp,
                                                    top = 5.dp,
                                                    end = 5.dp,
                                                    bottom = 5.dp
                                                )

                                        )

                                    }

                                    Spacer(modifier = Modifier.width(5.dp))

                                    Card (
                                        colors =CardDefaults.cardColors(Color.Transparent),
                                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                                        border = BorderStroke(1.dp, Color.Black),
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .padding(
                                                start = 10.dp,
                                                bottom = 10.dp,
                                                end = 10.dp,
                                                top = 20.dp
                                            )
                                            .size(width = 100.dp, height = 150.dp)

                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_app_logo) ,
                                            contentDescription = "Logo",

                                            modifier = Modifier
                                                .clip(CircleShape)
                                                .padding(
                                                    start = 5.dp,
                                                    top = 5.dp,
                                                    end = 5.dp,
                                                    bottom = 5.dp
                                                )
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))

                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           horizontalArrangement = Arrangement.Center
                       ) {
                           Card(

                               onClick = {navController.navigate(ROUTE_REGISTRATION) },
                               elevation = CardDefaults.cardElevation(20.dp),
                               colors = CardDefaults.cardColors(Color(0xff87CEEB)),
                               modifier = Modifier
                                   .padding(start = 80.dp, end = 50.dp,)
                                   .size(width = 300.dp, height = 100.dp)
                                   .clip(RoundedCornerShape(40.dp))
                           ) {
                               Text(
                                   text = "Get Started",
                                   textAlign = TextAlign.Center,
                                   fontSize = 20.sp,
                                   fontWeight = FontWeight.SemiBold,
                                   color = Color.White,
                                   modifier = Modifier.padding(start = 100.dp, top = 30.dp, end = 50.dp, )

                                   )



                           }
                       }




                    }
                }


            }




        )

    }




}













@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    DashboardScreen(rememberNavController())
}

