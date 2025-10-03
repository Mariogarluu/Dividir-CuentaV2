package com.example.dividircuentas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dividircuentas.ui.theme.DividirCuentasTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DividirCuentasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TipCalculatorScreen(modifier: Modifier = Modifier) {
    var billAmount by remember { mutableStateOf("") }
    var diners by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf(0f) }
    var roundUp by remember { mutableStateOf(false) }

    var totalWithTip by remember { mutableStateOf(0f) }
    var amountPerDiner by remember { mutableStateOf(0f) }

    LaunchedEffect(roundUp) {
        if (!roundUp) {
            tipPercentage = 0f
        }
    }

    LaunchedEffect(billAmount, diners, tipPercentage, roundUp) {
        val amountFloat = billAmount.toFloatOrNull() ?: 0f
        val dinersInt = diners.toIntOrNull() ?: 1

        val (total, perDiner) = calculateDivision(
            billAmount = amountFloat,
            numberOfDiners = dinersInt,
            tipPercentage = tipPercentage,
            roundUp = roundUp
        )
        totalWithTip = total
        amountPerDiner = perDiner
    }

    Column(
        modifier = modifier
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.total_to_pay, totalWithTip),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.each_pays, amountPerDiner),
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = { Text(stringResource(R.string.bill_amount)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = diners,
            onValueChange = { diners = it },
            label = { Text(stringResource(R.string.number_of_diners)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.round_tip))
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        AnimatedVisibility(visible = roundUp) {
            Column {
                Text(text = stringResource(R.string.tip_percentage, tipPercentage.toInt()))
                Slider(
                    value = tipPercentage,
                    onValueChange = { tipPercentage = it },
                    valueRange = 0f..30f,
                    steps = 5,
                    enabled = roundUp
                )
            }
        }
    }
}

private fun calculateDivision(
    billAmount: Float,
    numberOfDiners: Int,
    tipPercentage: Float,
    roundUp: Boolean
): Pair<Float, Float> {
    if (billAmount <= 0f) {
        return Pair(0f, 0f)
    }
    val actualDiners = if (numberOfDiners > 0) numberOfDiners else 1

    val tipMultiplier = 1 + tipPercentage / 100
    var totalAmount = billAmount * tipMultiplier

    if (roundUp) {
        totalAmount = round(totalAmount)
    }

    val amountPerDiner = totalAmount / actualDiners

    return Pair(totalAmount, amountPerDiner)
}


@Preview(showBackground = true)
@Composable
fun TipCalculatorScreenPreview() {
    DividirCuentasTheme {
        TipCalculatorScreen()
    }
}
