package com.nowni.jetpackcomposeproject.apps_list1.art_space_app

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.apps_list1.art_space_app.ui.theme.ArtSpaceAppTheme
import com.nowni.jetpackcomposeproject.apps_list1.art_space_app.ui.theme.Gainsboro

class ArtSpaceAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceAppLayout()

                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppLayout() {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
//    val contexts = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .safeDrawingPadding()
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        ImageCard(image = R.drawable.androidparty)
        ImageDetailAndPainter(
            imageDescription = R.string.image_desp_1,
            painterName = R.string.painters_name_1,
            paintingYear = R.string.painting_year_1
        )
        PrevAndNextButtons(onPreviousButton = {
//            Toast.makeText(contexts, "Previous", Toast.LENGTH_SHORT).show()

        }, onNextButton = {
//            Toast.makeText(contexts, "Next", Toast.LENGTH_SHORT).show()
        })

    }


}

@Composable
fun ImageCard(
    @DrawableRes image: Int, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp)
            .shadow(20.dp)
            .background(Color.White),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 450.dp)
                .padding(40.dp)
                .background(Color.Red)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ImageDetailAndPainter(
    @StringRes imageDescription: Int,
    painterName: Int,
    paintingYear: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
            .background(Gainsboro)
    ) {
        Column(
            modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = imageDescription),
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                maxLines = 2,
                lineHeight = 25.sp,
                textAlign = TextAlign.Left,
                modifier = modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, start = 20.dp, bottom = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = stringResource(id = painterName),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = modifier.padding()
                )
                Text(
                    text = "(${stringResource(id = paintingYear)})",
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
fun PrevAndNextButtons(
    onPreviousButton: () -> Unit,
    onNextButton: () ->Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, top = 30.dp, bottom = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {
            onPreviousButton()
            showToast(context,"Previous")
        }) {
            Text(
                text = "Previous",
                textAlign = TextAlign.Center,
                modifier = modifier.width(80.dp)
            )
//            Toast.makeText(context, "Previous", Toast.LENGTH_SHORT).show()
        }

        Button(onClick = { onNextButton()
        showToast(context,"Next")
        }) {
            Text(
                text = "Next",
                textAlign = TextAlign.Center,
                modifier = modifier.width(80.dp),
            )
//            Toast.makeText(context, "Next", Toast.LENGTH_SHORT).show()
        }
    }
}

internal fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


@Preview(
    showBackground = true, showSystemUi = true, name = "Art Space App"
)
@Composable
fun GreetingPreview3() {
    ArtSpaceAppTheme {
        ArtSpaceAppLayout()
    }
}