package com.example.assignment;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.assignment.viewmodel.ProductViewModel
import com.example.orderapp.ui.screens.BarcodeScreen
import com.example.orderapp.ui.screens.HomeScreen
import com.example.orderapp.ui.screens.OrderScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ProductViewModel()
        setContent {
            var screen by remember { mutableStateOf("home") }

            when (screen) {
                "home" -> HomeScreen(
                    onNavigateOrder = { screen = "order" },
                    onNavigateBarcode = { screen = "barcode" }
                )
                "order" -> OrderScreen(viewModel = viewModel, onBack = { screen = "home" })
                "barcode" -> BarcodeScreen(viewModel = viewModel, onBack = { screen = "home" })
            }
        }
    }
}