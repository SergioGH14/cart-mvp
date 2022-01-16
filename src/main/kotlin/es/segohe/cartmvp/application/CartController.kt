package es.segohe.cartmvp.application

import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.Cart.CartData
import es.segohe.cartmvp.domain.model.Product.ProductData
import es.segohe.cartmvp.domain.model.id.CartId
import es.segohe.cartmvp.domain.model.id.ProductId
import es.segohe.cartmvp.domain.repositoy.CartRepository
import es.segohe.cartmvp.domain.repositoy.ProductRepository
import org.springframework.web.bind.annotation.*

@RestController
class CartController(
    val productRepository: ProductRepository,
    val cartRepository: CartRepository
) {

    @GetMapping("/products")
    fun getProducts(): List<ProductData>? {
        return productRepository.findAll()?.map { it.toData() }
    }

    @PostMapping("/carts")
    fun createCart(): String {
        val id = CartId()
        cartRepository.save(Cart(id))
        return id.toString()
    }
    @GetMapping("/carts/{id}")
    fun findCart(@PathVariable id: String): CartData? {
        return cartRepository.find(CartId(id))?.toData()
    }

    @PutMapping("/carts/{id}")
    fun addProductsToCart(@RequestBody products: List<String>, @PathVariable id: String){
        val cart = cartRepository.find(CartId(id))
        require(cart!=null)
        require(products.all { productRepository.find(ProductId(it)) != null })
        products.forEach { cart.addProduct(productRepository.find(ProductId(it))!!) }
        cartRepository.save(cart)
    }

    @PostMapping("/carts/{id}/pay")
    fun payCart(@PathVariable id: String){
        val cart = cartRepository.find(CartId(id))
        require(cart!=null)
        cart.payCart()
    }
}
