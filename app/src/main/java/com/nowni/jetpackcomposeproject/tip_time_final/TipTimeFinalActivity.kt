package com.nowni.jetpackcomposeproject.tip_time_final

import android.graphics.drawable.Icon
import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.tip_time_final.ui.theme.TipTimeFinalTheme
import java.text.NumberFormat
import java.util.Currency

class TipTimeFinalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeFinalApp()

                }
            }
        }
    }
}


@Composable
fun TipTimeFinalApp() {
    TipTimeLay()


}

@Composable
fun TipTimeLay() {
    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tipInput by remember { mutableStateOf("") }
    val tipPercentage = tipInput.toDoubleOrNull() ?: 0.0
    var roundup by remember { mutableStateOf(false) }
    val tip = tipCalculate(amount, tipPercentage, roundup)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            label = R.string.bill_amount,
            leadingIcon = R.drawable.money,
            value = amountInput,
            onValueChange = { amountInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField(
            label = R.string.tip_percentage,
            leadingIcon = R.drawable.percent,
            value = tipInput,
            onValueChange = { tipInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        RoundTheTipRow(
            roundUp = roundup, onRoundUpChange = {
                roundup = it
            }, modifier = Modifier.padding(bottom = 32.dp)
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
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    var isFocused by remember { mutableStateOf(false) }
    TextField(
        //        label = { Text(stringResource(R.string.bill_amount)) },
        label = { Text(stringResource(label)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon), contentDescription = null
            )
        },
        //        value = amountInput,
        value = value,
//        onValueChange = { amountInput = it },
        onValueChange = onValueChange, singleLine = true,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//        keyboardOptions = KeyboardOptions.Default.copy(
//            keyboardType = KeyboardType.Number,
//            imeAction = ImeAction.Next,
//        ),
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            if (value.isNotEmpty() && isFocused) {
                Icon(imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.clickable {
                        onValueChange("")
                    })
            }
        },
        modifier = modifier.onFocusChanged {
            isFocused = it.isFocused
        },
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean, onRoundUpChange: (Boolean) -> Unit, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChange,
            modifier = modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        )
    }

}

@VisibleForTesting
internal fun tipCalculate(amount: Double, tipPercentage: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercentage / 100 * amount
    val rupeeFormat = NumberFormat.getCurrencyInstance()
    rupeeFormat.currency = Currency.getInstance("INR")
//    return NumberFormat.getCurrencyInstance().format(tip)
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return rupeeFormat.format(tip)
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun TipTimeFinalPreview() {
    TipTimeFinalTheme {
        TipTimeFinalApp()

    }
}