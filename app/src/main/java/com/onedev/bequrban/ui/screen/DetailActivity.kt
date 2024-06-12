package com.onedev.bequrban.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import com.onedev.bequrban.theme.BequrbanTheme
import com.onedev.bequrban.theme.green
import com.onedev.bequrban.theme.greenOpacity
import com.onedev.bequrban.theme.sfProFamily

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
    Scaffold(
        bottomBar = {
            BuyNowButton()
        }
    ) { paddingValues ->
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
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Premium Goat",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = sfProFamily
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = null
            )
        }
    }
}

data class QurbanImageItem(val imageId: Int)

@Composable
fun ImageCarousel() {
    val items = listOf(
        QurbanImageItem(R.drawable.img_mbe_detail_1),
        QurbanImageItem(R.drawable.img_mbe_detail_2),
        QurbanImageItem(R.drawable.img_mbe_detail_3),
        QurbanImageItem(R.drawable.img_mbe_detail_4)
    )

    Column {
        Image(
            modifier = Modifier.height(300.dp),
            painter = painterResource(id = R.drawable.img_mbe_detail_big),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(items.size) { index ->
                Image(
                    modifier = Modifier
                        .width(120.dp)
                        .height(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(4.dp),
                    painter = painterResource(id = items[index].imageId),
                    contentDescription = null
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
            fontSize = 14.sp,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
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
                modifier = Modifier.size(20.dp),
                painter = icon,
                tint = Color.Black,
                contentDescription = null
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
fun BuyNowButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedButton(
            shape = RoundedCornerShape(24.dp),
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_message),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = green
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
fun TopSectionPreview() {
    BequrbanTheme {
        TopSection {}
    }
}

@Preview(showBackground = true)
@Composable
fun ImageCarouselPreview() {
    BequrbanTheme {
        ImageCarousel()
    }
}

@Preview(showBackground = true)
@Composable
fun AboutSectionPreview() {
    BequrbanTheme {
        AboutSection()
    }
}

@Preview(showBackground = true)
@Composable
fun TagSectionPreview() {
    BequrbanTheme {
        TagSection()
    }
}

@Preview(showBackground = true)
@Composable
fun BuyNowButtonPreview() {
    BequrbanTheme {
        BuyNowButton()
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    BequrbanTheme {
        DetailScreen {}
    }
}