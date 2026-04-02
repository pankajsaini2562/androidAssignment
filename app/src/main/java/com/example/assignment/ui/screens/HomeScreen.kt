package com.example.orderapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateOrder: () -> Unit, onNavigateBarcode: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Internal Business App")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onNavigateOrder) { Text("Order App") }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onNavigateBarcode) { Text("Barcode Scanner") }
    }
}