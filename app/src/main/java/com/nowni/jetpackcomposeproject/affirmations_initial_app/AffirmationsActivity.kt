package com.nowni.jetpackcomposeproject.affirmations_initial_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.affirmations_initial_app.data.DataSource
import com.nowni.jetpackcomposeproject.affirmations_initial_app.model.Affirmation
import com.nowni.jetpackcomposeproject.affirmations_initial_app.ui.theme.AffirmationsTheme

class AffirmationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()

                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {

    AffirmationList(affirmationList = DataSource().loadAffirmations())

}

@Composable
fun AffirmationsCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
                
            )
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) {affirmation ->
            AffirmationsCard(
                affirmation = affirmation,
                modifier = Modifier.padding(8.dp)
            )

        }

    }
}

@Preview(showBackground = true,
    showSystemUi = true,
    name = "Affirmation App")
@Composable
fun AffirmationPreview() {
    AffirmationsTheme {
//        AffirmationsCard(Affirmation(R.string.affirmation1,R.drawable.image1))
//        AffirmationList(affirmationList = DataSource().loadAffirmations())
        AffirmationsApp()
    }
}