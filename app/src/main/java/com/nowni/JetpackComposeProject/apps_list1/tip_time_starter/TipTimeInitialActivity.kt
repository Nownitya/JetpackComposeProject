package com.nowni.JetpackComposeProject.apps_list1.tip_time_starter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.JetpackComposeProject.apps_list1.tip_time_starter.ui.theme.TipTimeInitialTheme
import java.text.NumberFormat
import java.util.Currency

//var amountInput: MutableState<String> = mutableStateOf("0")
//var amountInput = mutableStateOf("0")

class TipTimeInitialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeInitialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeInitialApp()
                }
            }
        }
    }
}

@Composable
fun TipTimeInitialApp() {
    TipTimeLay()


}

@Composable
fun TipTimeLay() {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = tipCalculate(amount)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
//        value = amountInput,
//        onValueChange = { amountInput = it },
        label = { Text(stringResource(R.string.bill_amount)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier,
    )
}

private fun tipCalculate(amount: Double, tipPercentage: Double = 15.0): String {
    val tip = tipPercentage / 100 * amount
    val rupeeFormat = NumberFormat.getCurrencyInstance()
    rupeeFormat.currency = Currency.getInstance("INR")
//    return NumberFormat.getCurrencyInstance().format(tip)
    return rupeeFormat.format(tip)
}

//@Composable
//fun EditNumberField(
//    @StringRes label: Int,
//    @DrawableRes leadingIcon: Int,
//    keyboardOptions: KeyboardOptions,
//    value: String,
//    onValueChanged: (String) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    TextField(
//        value = value,
//        singleLine = true,
//        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
//        modifier = modifier,
//        onValueChange = onValueChanged,
//        label = { Text(stringResource(label)) },
//        keyboardOptions = keyboardOptions
//    )
//
//}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "TipTimeInitial"
)
@Composable
fun TipTimeInitialPreview() {
    TipTimeInitialTheme {
        TipTimeInitialApp()

    }
}