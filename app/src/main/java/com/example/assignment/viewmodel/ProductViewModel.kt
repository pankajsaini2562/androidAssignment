package com.example.assignment.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.assignment.repository.ProductRepository
import com.example.orderapp.model.Product

class ProductViewModel: ViewModel() {
    private val repository = ProductRepository()
    val products = mutableStateOf<List<Product>>(emptyList())
    val selectedProduct = mutableStateOf<Product?>(null)
    val quantity = mutableStateOf("")
    val customerType = mutableStateOf("Retail") // Dealer / Retail
    val totalPrice = mutableStateOf(0.0)

    val barcodeData = mutableStateOf("")
    val barcodeStatus = mutableStateOf("")
    val barcodeProductName = mutableStateOf("")

    init {

        products.value = repository.getProducts()

    }
    fun calculateTotal() {
        val qty = quantity.value.toIntOrNull() ?: 0
        selectedProduct.value?.let { product ->
            if (qty < product.MOQ) {
                totalPrice.value = 0.0
            } else {
                val price = if (customerType.value == "Dealer") product.price * 0.9 else product.price
                totalPrice.value = price * qty
            }
        }
    }


    fun validateBarcode(barcode: String) {
        barcodeData.value = barcode
        val lastDigit = barcode.last().digitToIntOrNull() ?: 1
        barcodeStatus.value = if (lastDigit % 2 == 0) "Valid ✅" else "Invalid ❌"
        barcodeProductName.value = "Dummy Product"
    }



}