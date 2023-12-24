package com.nowni.jetpackcomposeproject.birthday_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.birthday_card.ui.theme.BirthdayCardTheme
import com.nowni.jetpackcomposeproject.birthday_card.ui.theme.Purple40

class BirthdayCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =MaterialTheme.colorScheme.background
                    ) {
//                    BirthdayText(message = "Happy Birthday", from = "Nownitya")
                    BirthdayCardImage(message = "Happy Birthday", from = "Nownitya")
                }
            }
        }
    }
}

@Composable
fun BirthdayText(message:String, from:String, modifier:Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {
        Text(
            text = message,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontSize = 100.sp,
            fontStyle = FontStyle.Italic,
            lineHeight = 100.sp
        )
        Text(
            text = from,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            color = Purple40,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun BirthdayCardImage(message:String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        BirthdayText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "Birthday Card")
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
//        BirthdayText(message = "Happy Birthday", from = "Nownitya")
        BirthdayCardImage(message = "Happy Birthday", from = "Nownitya")

    }
}