package com.example.simpleapicallingwithretrofit.app.domain.model

data class ProductX(
    val id: Int = 0, // 1
    val title: String = "", // Essence Mascara Lash Princess
    val description: String = "", // The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.
    val category: String = "", // beauty
    val price: Double = 0.0, // 9.99
    val discountPercentage: Double = 0.0, // 7.17
    val rating: Double = 0.0, // 4.94
    val stock: Int = 0, // 5
    val tags: List<String> = listOf(),
    val brand: String? = null, // Essence
    val sku: String = "", // RCH45Q1A
    val weight: Int = 0, // 2
    val dimensions: Dimensions = Dimensions(),
    val warrantyInformation: String = "", // 1 month warranty
    val shippingInformation: String = "", // Ships in 1 month
    val availabilityStatus: String = "", // Low Stock
    val reviews: List<Review> = listOf(),
    val returnPolicy: String = "", // 30 days return policy
    val minimumOrderQuantity: Int = 0, // 24
    val meta: Meta = Meta(),
    val images: List<String> = listOf(),
    val thumbnail: String = "" // https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png
)