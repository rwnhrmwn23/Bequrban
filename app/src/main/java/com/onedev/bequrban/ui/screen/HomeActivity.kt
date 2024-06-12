package com.onedev.bequrban.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onedev.bequrban.R
import com.onedev.bequrban.theme.BequrbanTheme
import com.onedev.bequrban.theme.green
import com.onedev.bequrban.theme.sfProFamily
import com.onedev.bequrban.theme.yellow

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BequrbanTheme {
                HomeScreen {}
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigateToDetail: () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { paddingValues ->  
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                HeaderSection()
            }
            item {
                SearchSection()
            }
            item {
                QurbanTypeSection()
            }
            item {
                QurbanItemSection(onNavigateToDetail)
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Show bequrban providers in",
                fontSize = 16.sp,
                fontFamily = sfProFamily
            )
            Text(
                text = "Jakarta, Indonesia",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = sfProFamily
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notifications),
                contentDescription = null
            )
        }
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null
        )
    }
}

@Composable
fun SearchSection() {
    Box {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            painter = painterResource(id = R.drawable.ram_background),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_mbe),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Qurban legal and\neasy from home",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = sfProFamily
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Start",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = sfProFamily
                    )
                    Text(
                        text = "from",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = sfProFamily
                    )
                }
                Text(
                    text = "2.500K",
                    color = yellow,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sfProFamily
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                shape = RoundedCornerShape(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Search Now",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sfProFamily
                )
            }
        }
    }
}

@Composable
fun QurbanTypeSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "What type Qurban are you looking for ?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sfProFamily
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            QurbanTypeButton(type = "All", isActive = true)
            QurbanTypeButton(type = "Goat", isActive = false)
            QurbanTypeButton(type = "Sheep", isActive = false)
            QurbanTypeButton(type = "Cow", isActive = false)
        }
    }
}

@Composable
fun QurbanTypeButton(type: String, isActive: Boolean) {
    if (isActive) {
        Button(
            modifier = Modifier.padding(4.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = green),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = type,
                color = Color.White,
                fontFamily = sfProFamily
            )
        }
    } else {
        OutlinedButton(
            modifier = Modifier.padding(4.dp),
            shape = RoundedCornerShape(24.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = type,
                color = Color.Black,
                fontFamily = sfProFamily
            )
        }
    }

}

data class QurbanItemData(
    val name: String,
    val price: String,
    val weight: String,
    val imageId: Int,
)

@Composable
fun QurbanItemSection(onNavigateToDetail: () -> Unit) {
    val items = listOf(
        QurbanItemData("Normal Goat", "Rp2.500.000", "21 - 25 Kg", R.drawable.goat_normal),
        QurbanItemData("Premium Goat", "Rp2.900.000", "26 - 30 Kg", R.drawable.goat_premium)
    )

    Box(modifier = Modifier.fillMaxHeight()) {
        LazyVerticalGrid(
            modifier = Modifier
                .height(300.dp)
                .padding(horizontal = 8.dp)
                .clickable {
                    onNavigateToDetail()
                },
            columns = GridCells.Fixed(2)
        ) {
            items(items.size) { index ->
                QurbanItem(
                    name = items[index].name,
                    price = items[index].price,
                    weight = items[index].weight,
                    imageId = items[index].imageId
                )
            }
        }
    }
}

@Composable
fun QurbanItem(
    name: String,
    price: String,
    weight: String,
    imageId: Int
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.background(color = Color.White)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                painter = painterResource(id = imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(green)
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_guaranteed_healthy),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Guaranteed Healthy",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = sfProFamily
                    )
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = sfProFamily
                )
                Text(
                    text = price,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = sfProFamily
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_weight),
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = weight,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontFamily = sfProFamily
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_message),
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview() {
    HeaderSection()
}

@Preview(showBackground = true)
@Composable
fun SearchSectionPreview() {
    SearchSection()
}

@Preview(showBackground = true)
@Composable
fun QurbanTypeSectionPreview() {
    QurbanTypeSection()
}

@Preview(showBackground = true)
@Composable
fun QurbanItemPreview() {
    QurbanItem(
        "Normal Goat", "Rp2.500.000", "21 - 25 Kg", R.drawable.goat_normal
    )
}

@Preview(showBackground = true)
@Composable
fun QurbanItemSectionPreview() {
    QurbanItemSection { }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPrview() {
    BottomNavigationBar()
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BequrbanTheme {
        HomeScreen {}
    }
}