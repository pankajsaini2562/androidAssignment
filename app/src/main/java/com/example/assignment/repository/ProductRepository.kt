package com.example.assignment.repository

import com.example.orderapp.model.Product

class ProductRepository {

    fun getProducts():List<Product>{
        return listOf(

            Product(1, "Product A", 100.0, 5),
            Product(2, "Product B", 200.0, 10),
            Product(3, "Product C", 50.0, 2)
        )
    }
}