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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
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
import net.ezra.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController) {
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
                                painter = painterResource(id = R.drawable.mother),
                                contentDescription ="",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(width = 200.dp, height = 200.dp)
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
                                    .background(Color(0xffec0ac9))
                                    .size(width = 200.dp, height = 120.dp)

                            ){
                                Text(
                                    text = "Great Deals",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xfff5f0ee),
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(30.dp))
                                    .background(Color(0xff8808e6))
                                    .size(width = 200.dp, height = 120.dp)
                            ){
                                Text(
                                    text = "Great Deals",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xfff5f0ee),
                                    )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(30.dp))
                                    .background(Color(0xffe9550c))
                                    .size(width = 200.dp, height = 120.dp)
                            ){
                                Text(
                                    text = "Great Deals",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xfff5f0ee),
                                    )
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
                                    colors = CardDefaults.cardColors(Color(0xffc7e7eb )),
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
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_app_logo) ,
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
                                    colors = CardDefaults.cardColors(Color(0xffc7e7eb )),
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
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_app_logo) ,
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
                                    colors = CardDefaults.cardColors(Color(0xfff5a59b  )),
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
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_app_logo) ,
                                        contentDescription = "Logo",
                                        tint = Color(0xfff05a0a),
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
                                    colors = CardDefaults.cardColors(Color(0xffc2f59b  )),
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
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_app_logo) ,
                                        contentDescription = "Logo",
                                        tint = Color(0xfff05a0a),
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
                                    colors = CardDefaults.cardColors(Color(0xff )),
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
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_app_logo) ,
                                        contentDescription = "Logo",
                                        tint = Color(0xfff05a0a),
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
                    Row {
                        Text(
                            text = "Others",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    LazyRow {
                        item {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xffd8f9bf))
                                    .size(width = 100.dp, height = 100.dp)
                            ){
                                Icon(
                                    imageVector = Icons.Default.AccountBox,
                                    contentDescription ="",
                                    tint = Color.Green,
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xfffabae0))
                                    .size(width = 100.dp, height = 100.dp)
                            ){
                                Icon(
                                    imageVector = Icons.Default.Build,
                                    contentDescription ="",
                                    tint = Color(0xffc219ec),
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Color(0xffbfc7fe))
                                    .size(width = 100.dp, height = 100.dp)
                            ){
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription ="",
                                    tint = Color(0xff1731ee),
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }



                }
            }
                BottomSection()
    






}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomSection(){
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
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
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
                                    
                                    contentDescription = item.title
                                
                                )
                                
                                
                            }
                            
                        }
                    )
                    
                }
            }
        }
    ) {

    }


}


@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    DashboardScreen(rememberNavController())
}

