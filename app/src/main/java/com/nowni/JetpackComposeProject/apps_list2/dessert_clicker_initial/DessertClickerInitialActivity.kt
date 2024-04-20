package com.nowni.JetpackComposeProject.apps_list2.dessert_clicker_initial

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.nowni.jetpackcomposeproject.R
import com.nowni.JetpackComposeProject.apps_list2.dessert_clicker_initial.data.DataSourceDessert
import com.nowni.JetpackComposeProject.apps_list2.dessert_clicker_initial.model.Dessert
import com.nowni.JetpackComposeProject.apps_list2.dessert_clicker_initial.ui.theme.DessertTheme

private const val TAG = "DessertClickerInitialActivity"

class DessertClickerInitialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            DessertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    DessertClickerApp(desserts = DataSourceDessert.dessertList)

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

fun determineDessertToShow(
    desserts: List<Dessert>,
    dessertsSold: Int
): Dessert {

    var dessertToShow = desserts.first()
    for (dessert in desserts) {
        if (dessertsSold >= dessert.startProductionAmount) {
            dessertToShow = dessert
        } else {
            break
        }
    }
    return dessertToShow
}

private fun shareSoldDessertsInformation(
    intentContext: Context, dessertsSold: Int, revenue: Int
) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT, intentContext.getString(R.string.share_text, dessertsSold, revenue)
        )
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)

    try {
        ContextCompat.startActivity(intentContext, shareIntent, null)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            intentContext,
            intentContext.getString(R.string.sharing_not_available),
            Toast.LENGTH_SHORT
        ).show()
    }
}

@Composable
fun DessertClickerApp(
    desserts: List<Dessert>
) {
    var revenue by rememberSaveable { mutableStateOf(0) }
//    var revenue by remember { mutableStateOf(0) }

    var dessertSold by rememberSaveable { mutableStateOf(0) }

    val currentDessertIndex by rememberSaveable { mutableStateOf(0) }

    var currentDessertPrice by rememberSaveable {
        mutableStateOf(desserts[currentDessertIndex].price)
    }

    var currentDessertImageId by rememberSaveable {
        mutableStateOf(desserts[currentDessertIndex].imageId)
    }
//    var currentDessertImageId by remember {
//        mutableStateOf(desserts[currentDessertIndex].imageId)
//    }

    Scaffold(topBar = {
        val intentContent = LocalContext.current
        DessertClickerAppBar(
            onShareButtonClicked = {
                shareSoldDessertsInformation(
                    intentContext = intentContent, dessertsSold = dessertSold, revenue = revenue
                )
            }, modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        )
    }) { contentPadding ->
        DessertClickerScreen(
            revenue = revenue,
            dessertsSold = dessertSold,
            dessertImageId = currentDessertImageId,
            onDessertClicked = {
                //  Update the revenue
                revenue += currentDessertPrice
                dessertSold++

                //  Show the next dessert
                val dessertToShow = determineDessertToShow(desserts, dessertSold)
                currentDessertImageId = dessertToShow.imageId
                currentDessertPrice = dessertToShow.price
            },
            modifier = Modifier.padding(contentPadding)
        )
    }
}

@Composable
fun DessertClickerAppBar(
    onShareButtonClicked: () -> Unit, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.dessert_clicker_initial),
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge
        )
        IconButton(
            onClick = onShareButtonClicked,
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun DessertClickerScreen(
    revenue: Int,
    dessertsSold: Int,
    @DrawableRes dessertImageId: Int,
    onDessertClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.bakery_back),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            Box(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = dessertImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.image_size))
                        .height(dimensionResource(id = R.dimen.image_size))
                        .align(Alignment.Center)
                        .clickable { onDessertClicked() },
                    contentScale = ContentScale.Crop
                )
            }
            TransactionInfo(
                revenue = revenue,
                dessertSold = dessertsSold,
                modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
            )
        }
    }


}

@Composable
fun TransactionInfo(
    revenue: Int, dessertSold: Int, modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        DessertSoldInfo(
            dessertSold = dessertSold, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimensionResource(id = R.dimen.padding_medium)
                )
        )
        RevenueInfo(
            revenue = revenue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }

}

@Composable
fun RevenueInfo(revenue: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.total_revenue),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = "₹${revenue}",
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )


    }

}

@Composable
fun DessertSoldInfo(dessertSold: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.dessert_sold),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = dessertSold.toString(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )

    }


}

@Preview(
    showBackground = true, showSystemUi = true, name = "Dessert Light"
)
@Composable
fun DessertPreviewLight() {
    DessertTheme(darkTheme = false) {
        Surface {
//            DessertSoldInfo(dessertSold = R.string.dessert_sold)
//            RevenueInfo(revenue = 444)
//            TransactionInfo(revenue = 44, dessertSold = 7)
//            DessertClickerScreen(revenue = 44,
//                dessertsSold = 4,
//                dessertImageId = R.drawable.cupcake,
//                onDessertClicked = { /*TODO*/ })
//            DessertClickerAppBar(onShareButtonClicked = { /*TODO*/ })
            DessertClickerApp(desserts = DataSourceDessert.dessertList)

        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DessertPreviewDark() {
    DessertTheme {
        Surface {
//            DessertSoldInfo(dessertSold = R.string.dessert_sold)
//            DessertClickerScreen(revenue = 44,
//                dessertsSold = 4,
//                dessertImageId = R.drawable.cupcake,
//                onDessertClicked = { /*TODO*/ })
//            DessertClickerAppBar(onShareButtonClicked = { /*TODO*/ })
            DessertClickerApp(desserts = DataSourceDessert.dessertList)

        }
    }
}