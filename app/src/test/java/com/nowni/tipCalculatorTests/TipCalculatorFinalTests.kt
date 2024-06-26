package com.nowni.tipCalculatorTests

import com.nowni.JetpackComposeProject.apps_list1.tip_time_final.tipCalculate
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorFinalTests {

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = tipCalculate(amount = amount, tipPercentage = tipPercent, false)
        assertEquals(expectedTip,actualTip)
    }
}