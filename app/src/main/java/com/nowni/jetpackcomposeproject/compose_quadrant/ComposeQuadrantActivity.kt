package com.nowni.jetpackcomposeproject.compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.jetpackcomposeproject.compose_quadrant.ui.theme.ComposeQuadrantTheme

class ComposeQuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()

                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposeInfoCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            ComposeInfoCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F),
            )

        }
        Row(Modifier.weight(1f)) {
            ComposeInfoCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            ComposeInfoCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun ComposeInfoCard(
    title: String,
    description: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )


    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Compose Quadrant"
)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}
