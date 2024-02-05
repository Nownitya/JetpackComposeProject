package com.nowni.jetpackcomposeproject.apps_list.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.apps_list.compose_article.ui.theme.ComposeArticleTheme

class ComposeArticleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        image = painterResource(R.drawable.bg_compose_background),
        title = stringResource(R.string.title_jetpack_compose_tutorial),
        shortDescription = stringResource(R.string.short_desp_jetpack_compose_tutorial),
        longDescription = stringResource(R.string.long_desp_jetpack_compose_tutorial)
    )

}

@Composable
fun ArticleCard(
    image : Painter,
    title:String,
    shortDescription:String,
    longDescription: String,
    modifier:Modifier=Modifier,
) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold ,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            )

        Text(
            text = shortDescription,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )

        Text(
            text = longDescription,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)

        )



    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Compose Article"
)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ComposeArticleApp()

    }
}

