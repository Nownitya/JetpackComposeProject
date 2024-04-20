package com.nowni.JetpackComposeProject.apps_list2.Desert_Clicker_ViewModel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nowni.JetpackComposeProject.apps_list2.Desert_Clicker_ViewModel.data.DataSource
import com.nowni.JetpackComposeProject.apps_list2.Desert_Clicker_ViewModel.model.Dessert
import com.nowni.JetpackComposeProject.apps_list2.Desert_Clicker_ViewModel.ui.theme.DessertClickerViewModelTheme
import com.nowni.JetpackComposeProject.apps_list2.dessert_clicker_initial.DessertClickerApp

class DessertClickerViewModelActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DessertClickerViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DessertClickerViewModelApp(desserts = DataSource.dessertList)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    
}



class DessertClickerViewModelApp(desserts: List<Dessert>) {


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DessertClickerViewModelTheme {
        Greeting("Android")
    }
}