package es.segohe.cartmvp.application

import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.CartId
import es.segohe.cartmvp.domain.repositoy.CartRepository
import es.segohe.cartmvp.domain.repositoy.ProductRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController(
    val productRepository: ProductRepository,
    val cartRepository: CartRepository
) {

    fun getProducts(): List<Product>? {
        return productRepository.findAll()
    }

    fun createCart(): String {
        val id = CartId()
        cartRepository.save(Cart(CartId()))
        return id.toString()
    }

    fun findCart(id:String){
        cartRepository.find(CartId(id))
    }

    fun payCart(id:String){
        val cart = cartRepository.find(CartId(id))
        require(cart!=null)
        cart.payCart()
    }
}
