package com.shameem.composefirstlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shameem.composefirstlesson.ui.theme.ComposeFirstLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFirstLessonTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    val painter = painterResource(id = R.drawable.ic_launcher_background)
                    val description = "Hello World"
                    val title ="Also Hello World"
                    Box(modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(16.dp)) {
                        ImageCard(painter = painter
                            , contentDescription =description,
                            title =title)
                    }
                
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 330f
                )))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color=Color.White, fontSize =16.sp ) )
            }
            
            
        }

    }

}

@Composable
fun Greeting(name: String) {
    Column(){
        Text(text = "Welcome to Home", textAlign =
        TextAlign.Center,color=Color.White)
        Text(text = name, textAlign = TextAlign.Center,
            color= Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFirstLessonTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val painter = painterResource(id = R.drawable.ic_launcher_background)
            val description = "Hello World"
            val title ="Also This a text for test."
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {
                ImageCard(painter = painter
                    , contentDescription =description,
                    title =title)
            } }
        }

}