package com.example.orderapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment.viewmodel.ProductViewModel

@Composable
fun OrderScreen(viewModel: ProductViewModel, onBack: () -> Unit) {
    val products by viewModel.products
    val selectedProduct by viewModel.selectedProduct
    val quantity by viewModel.quantity
    val customerType by viewModel.customerType
    val totalPrice by viewModel.totalPrice

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Customer Type:")
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Button(onClick = { viewModel.customerType.value = "Retail" }) { Text("Retail") }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { viewModel.customerType.value = "Dealer" }) { Text("Dealer") }
        }

        LazyColumn(modifier = Modifier.height(200.dp)) {
            items(products) { product ->
                Text(
                    "${product.name} | Price: ${product.price} | MOQ: ${product.MOQ}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.selectedProduct.value = product }
                        .padding(4.dp)
                        .then(if (selectedProduct?.id == product.id) Modifier else Modifier)
                )
            }
        }

        OutlinedTextField(
            value = quantity,
            onValueChange = { viewModel.quantity.value = it },
            label = { Text("Quantity") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Button(onClick = {
            val qty = quantity.toIntOrNull() ?: 0
            val product = selectedProduct
            if (product == null || qty == 0) return@Button
            if (qty < product.MOQ) {
                // MOQ error
                return@Button
            }
            viewModel.calculateTotal()
        }) {
            Text("Place Order")
        }

        Text("Total Price: $totalPrice", modifier = Modifier.padding(vertical = 8.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBack) { Text("Back") }
    }
}