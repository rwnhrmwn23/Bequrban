package com.onedev.bequrban.ui.screen.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onedev.bequrban.R
import com.onedev.bequrban.ui.theme.BequrbanTheme
import com.onedev.bequrban.ui.theme.green
import com.onedev.bequrban.ui.theme.greenOpacity
import com.onedev.bequrban.ui.theme.sfProFamily

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BequrbanTheme {
                DetailScreen {}
            }
        }
    }
}

@Composable
fun DetailScreen(onBack: () -> Unit) {
    Scaffold(bottomBar = {
        BuyNowButton()
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TopSection(onBack = onBack)
            ImageCarousel()
            AboutSection()
            TagSection()
        }
    }
}

@Composable
fun TopSection(onBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "Premium Goat",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sfProFamily
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle share click */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = "Share"
            )
        }
    }
}

data class QurbanItemData(val imageId: Int)

@Composable
fun ImageCarousel() {
    val items = listOf(
        QurbanItemData(R.drawable.img_mbe_detail_1),
        QurbanItemData(R.drawable.img_mbe_detail_2),
        QurbanItemData(R.drawable.img_mbe_detail_3),
        QurbanItemData(R.drawable.img_mbe_detail_4),
    )
    Column(
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_mbe_detail_big),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(300.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(items.size) { index ->
                Image(
                    painter = painterResource(id = items[index].imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun AboutSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "About",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sfProFamily
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "The Premium Goat embodies the pinnacle of excellence in qurban animals. With its impeccable features and exceptional qualities, this remarkable goat stands out from the rest. Its physique exudes elegance, with a well-proportioned body, graceful stance, and a distinguished presence. The Premium Goat showcases a broad forehead, beautifully curved horns, and a luxurious coat that captivates with shades of pristine white, deep black, or an enchanting blend of both. Beyond its physical attributes, the Premium Goat is carefully selected for its optimal age, robust health, and ideal weight, ensuring a superior offering for families and communities. Embrace the epitome of distinction and elevate your qurban experience with the magnificent Premium Goat.",
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            textAlign = TextAlign.Justify,
            fontFamily = sfProFamily
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Read more",
            fontSize = 14.sp,
            color = green,
            fontFamily = sfProFamily
        )

    }
}

@Composable
fun TagSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TagItem(
            icon = painterResource(id = R.drawable.ic_guaranteed_healthy),
            text = "Guaranteed Healthy"
        )
        TagItem(
            icon = painterResource(id = R.drawable.ic_weight),
            text = "26 - 30 Kg"
        )
        TagItem(
            icon = painterResource(id = R.drawable.ic_trolly),
            text = "Free Shipping"
        )
    }
}

@Composable
fun TagItem(icon: Painter, text: String) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = greenOpacity
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                color = Color.Black,
                fontSize = 14.sp,
                fontFamily = sfProFamily
            )
        }
    }
}

@Composable
fun BuyNowButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedButton(
            onClick = { },
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFF34A853)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Buy Now",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = sfProFamily
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen() {
    BequrbanTheme {
        DetailScreen { }
    }
}