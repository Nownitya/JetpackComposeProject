package com.nowni.tipCalculatorTest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.nowni.jetpackcomposeproject.tip_time_final.TipTimeFinalApp
import com.nowni.jetpackcomposeproject.tip_time_final.ui.theme.TipTimeFinalTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Currency

class TipCalculatorUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percentage_tip() {
        composeTestRule.setContent {
            TipTimeFinalTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipTimeFinalApp()
                }
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
//        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val expectedTip = NumberFormat.getCurrencyInstance().apply {
            currency = Currency.getInstance("INR")
        }.format(2)
        composeTestRule.onNodeWithText(
            "Tip Amount: $expectedTip",
            ignoreCase = true)
            .assertExists("No node with this text was found.")
    }
}