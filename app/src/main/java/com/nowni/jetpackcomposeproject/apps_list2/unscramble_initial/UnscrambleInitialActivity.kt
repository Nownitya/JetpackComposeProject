package com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial.ui.GameScreen
import com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial.ui.theme.JetpackComposeProjectTheme
import com.nowni.jetpackcomposeproject.apps_list2.unscramble_initial.ui.theme.UnscrambleTheme

class UnscrambleInitialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
//                    TextBoxes()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun UnscrambleDark() {
    UnscrambleTheme {
        Surface {
            GameScreen()
//            TextBoxes()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun UnscrambleLight() {
    UnscrambleTheme {
        Surface {
            GameScreen()
        }

    }
}
