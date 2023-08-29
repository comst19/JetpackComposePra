package com.comst.constraintlayoututilize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.comst.constraintlayoututilize.MainActivity.Companion.cardData
import com.comst.constraintlayoututilize.ui.theme.ConstraintLayoutUtilizeTheme

class MainActivity : ComponentActivity() {

    companion object {
        val cardData = CardData(
            imageUri = "https://avatars.githubusercontent.com/u/69802523?v=4",
            imageDescription = "깃허브 프로필 사진",
            author = "comst",
            description = "깃허브 comst의 프로필"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutUtilizeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Column {
                        CardEx(cardData)
                    }
                }
            }
        }
    }
}

@Composable
fun CardEx(cardData : CardData) {

    val placeHolder = Color(0x33000000)

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ){
        ConstraintLayout(
        ) {
            val (profileImage, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                        //linkTo(parent.top, parent.bottom)
                    },
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(placeHolder)
            )

            Text(
                text = cardData.author,
                modifier = Modifier.constrainAs(author){
                    linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = cardData.description,
                modifier = Modifier.constrainAs(description){
                    linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                    width = Dimension.fillToConstraints
                }
            )

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

//            constrain(chain){
//                top.linkTo(parent.top, margin = 8.dp)
//                bottom.linkto(parent.bottom, margin = 8.dp)
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutUtilizeTheme {
        CardEx(MainActivity.cardData)
    }
}

data class CardData(
    val imageUri : String,
    val imageDescription : String,
    val author : String,
    val description : String
)