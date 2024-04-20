package com.nowni.JetpackComposeProject.apps_list1.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.JetpackComposeProject.apps_list1.business_card.ui.theme.BusinessCardTheme
import com.nowni.JetpackComposeProject.apps_list1.business_card.ui.theme.Gainsboro
import com.nowni.JetpackComposeProject.apps_list1.business_card.ui.theme.OxfordBlue
import com.nowni.JetpackComposeProject.apps_list1.business_card.ui.theme.RoyalGreen
import com.nowni.jetpackcomposeproject.R

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayCardApp()

                }
            }
        }
    }
}

@Composable
fun BirthdayCardApp() {

//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Gainsboro)
//    ) {
//        item() {
//            TopBox()
//        }
//        item {
//
//        }
//        item { BottomBox() }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gainsboro),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints(
            modifier = Modifier.padding(top = 150.dp)
        ) { TopBox() }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.padding(top = 100.dp, bottom = 0.dp)
        ) { BottomBox() }
    }

}

@Composable
fun TopBox() {
    BoxWithConstraints() {
        NameTitle(
            image = painterResource(R.drawable.android_logo),
            name = "Nownitya Sharma",
            description = "Android Developer Extraordinaire",
        )
    }
}


@Composable
fun BottomBox() {

    BoxWithConstraints(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp), Alignment.BottomCenter
    ) {
        Column() {
            UserDetail(icon = painterResource(R.drawable.ic_call), text = "+91 9999999999")
            UserDetail(icon = painterResource(R.drawable.ic_share), text = "@Nownitya")
            UserDetail(icon = painterResource(R.drawable.ic_call), text = "nownitya@gmail.com")
        }
    }
}

@Composable
fun NameTitle(image: Painter, name: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image, contentDescription = null,
            Modifier
                .size(150.dp)
                .background(OxfordBlue)
        )
        Text(
            text = name,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
            fontSize = 34.sp,
            lineHeight = 100.sp,
        )

        Text(
            text = description,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
            fontSize = 14.sp,
            color = RoyalGreen,
            fontWeight = FontWeight.ExtraBold
        )

    }


}


@Composable
fun UserDetail(icon: Painter, text: String, modifier: Modifier = Modifier) {
    Row(
        Modifier.padding(top = 10.dp)
    ) {
        Image(painter = icon, contentDescription = null)
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace,
            modifier = modifier.padding(start = 20.dp)
        )
    }
}


@Preview(
    showBackground = true, showSystemUi = true, name = "Birthday Card"
)
@Composable
fun BirthdayCardPreview() {
    BusinessCardTheme {
        val image = painterResource(R.drawable.android_logo)
        BirthdayCardApp()
    }
}

