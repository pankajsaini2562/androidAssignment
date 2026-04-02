package com.example.orderapp.ui.screens

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.assignment.viewmodel.ProductViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun BarcodeScreen(viewModel: ProductViewModel, onBack: () -> Unit) {
    val context = LocalContext.current
    val barcodeData by viewModel.barcodeData
    val barcodeStatus by viewModel.barcodeStatus
    val barcodeProductName by viewModel.barcodeProductName

    // Initialize the ActivityResultLauncher
    val barcodeLauncher = rememberLauncherForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            viewModel.validateBarcode(result.contents)
            Toast.makeText(context, "Scanned: ${result.contents}", Toast.LENGTH_SHORT).show()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Barcode Scanner")
        Spacer(modifier = Modifier.height(10.dp))

        // Scan button
        Button(onClick = {
            // Properly create ScanOptions before launching
            val scanOptions = ScanOptions().apply {
                setPrompt("Scan a barcode")
                setBeepEnabled(true)
                setBarcodeImageEnabled(true)
            }
            barcodeLauncher.launch(scanOptions)
        }) {
            Text("Scan Barcode")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display scanned product info
        if (barcodeProductName.isNotEmpty()) {
            Text("Product Name: $barcodeProductName")
            Text("Status: $barcodeStatus")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Back button
        Button(onClick = onBack) { Text("Back") }
    }
}