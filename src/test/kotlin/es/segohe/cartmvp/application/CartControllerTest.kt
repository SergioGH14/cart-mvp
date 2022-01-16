package es.segohe.cartmvp.application

import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.CartId
import es.segohe.cartmvp.domain.model.id.ProductId
import es.segohe.cartmvp.infrastructure.repository.InMemoryCartRepository
import es.segohe.cartmvp.infrastructure.repository.InMemoryMockedProductRepository
import es.segohe.cartmvp.infrastructure.repository.InMemoryProductRepository
import io.mockk.clearMocks
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class CartControllerTest {

    private lateinit var cartId: CartId

    @BeforeEach
    fun beforeEach() {
        cartRepository.clear()
        productRepository.clear()
        cartId = `cart in repository`()
        clearMocks(cartRepository, productRepository)
    }

    @Test
    fun `createCart creates new cart`() {
        val id = controller.createCart()
        verify { cartRepository.save(any()) }
        assertNotNull(cartRepository.find(CartId(id)))
    }

    @Test
    fun `given an existing cart id findCart returns a cart`() {
        val cartData = controller.findCart(cartId.toString())
        assertNotNull(cartData)
        assertEquals(cartId.toString(), cartData!!.id)
    }

    @Test
    fun `given non existing cart id findCart returns null`() {
        val cartData = controller.findCart(CartId().toString())
        assertNull(cartData)
    }

    @Test
    fun `given an existing cart id and existing products then add the products to the cart`() {
        val products = `products in repository`().map { it.toString() }

        controller.addProductsToCart(products, cartId.toString())

        verify { cartRepository.find(cartId) }
        verify { cartRepository.save(match { it.id == cartId }) }
        assertEquals(products.size, cartRepository.find(cartId)?.getProducts()?.size)
    }

    @Test
    fun `given an existing cart id and non existing products then return error`() {
        val products = `products not in repository`().map { it.toString() }

        assertThrows<IllegalArgumentException> { controller.addProductsToCart(products, cartId.toString()) }

        verify { cartRepository.find(cartId) }
        verify(exactly = 0) { cartRepository.save(match { it.id == cartId }) }
        assertEquals(0, cartRepository.find(cartId)?.getProducts()?.size)
    }

    @Test
    fun `given a non existing cart id when adding products then return error`() {
        val products = `products in repository`().map { it.toString() }
        val cartId = CartId()
        assertThrows<IllegalArgumentException> { controller.addProductsToCart(products, cartId.toString()) }
        verify { cartRepository.find(cartId) }
        verify(exactly = 0) { productRepository.find(any()) }
    }

    @Test
    fun `given an existing cart id payCart turns the cart paid`() {
        controller.payCart(cartId.toString())
        assertNotNull(cartRepository.find(cartId))
        assertTrue(cartRepository.find(cartId)!!.isPaid())
    }

    @Test
    fun `given non existing cart id payCart returns error`() {
        assertThrows<IllegalArgumentException> { controller.payCart(CartId().toString()) }
    }

    private fun `products in repository`(): List<ProductId> {
        productRepository.mockDatabase()
        return productRepository.findAll()!!.map { it.id }
    }

    private fun `products not in repository`(): List<ProductId> {
        productRepository.mockDatabase()
        val products = productRepository.findAll()!!.map { it.id }
        productRepository.clear()
        return products
    }

    private fun `cart in repository`(): CartId {
        val id = CartId()
        cartRepository.save(Cart(id))
        return id

    }

    private val cartRepository = spyk(InMemoryCartRepository())
    private val productRepository = spyk(InMemoryMockedProductRepository())
    private val controller = CartController(productRepository, cartRepository)
}
