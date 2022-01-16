package es.segohe.cartmvp.domain.model

import es.segohe.cartmvp.domain.common.Entity
import es.segohe.cartmvp.domain.model.id.CartId

class Cart(id: CartId) : Entity<CartId>(id) {

    private var isPaid = false

    private val products = mutableListOf<Product>()

    fun payCart() {
        isPaid = true
    }

    fun addProduct(product: Product) {
        products.add(product)
    }

    private fun getTotalPrice(): Double {
        require(products.isNotEmpty()) { return 0.0 }
        return products.map { it.price }.reduce { acc, product -> acc + product }
    }

    fun getProducts() = products.map{it.toData()}.toList()
    fun isPaid() = isPaid

    fun toData(): CartData {

        return CartData(id.toString(), getProducts(), isPaid, getTotalPrice())
    }


    data class CartData(val id: String, val products: List<Product.ProductData>, val isPaid: Boolean, val price: Double)

}
