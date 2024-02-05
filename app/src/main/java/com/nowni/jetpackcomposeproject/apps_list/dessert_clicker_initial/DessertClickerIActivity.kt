package com.nowni.jetpackcomposeproject.apps_list.dessert_clicker_initial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nowni.jetpackcomposeproject.apps_list.dessert_clicker_initial.ui.theme.DessertClickerTheme

class DessertClickerIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DessertClickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun DessertClickerApp() {
//    DessertClickerScreen(
//        revenue = ,
//        dessertsSold = ,
//        dessertImageId = ,
//        onDessertClicked = { /*TODO*/ })

}

@Composable
fun DessertClickerScreen(
    revenue: Int,
    dessertsSold: Int,
    dessertImageId: Int,
    onDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {



}




@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Dessert Clicker"
)
@Composable
fun GreetingPreview4() {
    DessertClickerTheme {

    }
}