package es.segohe.cartmvp.infrastructure.repository

import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.id.CartId
import es.segohe.cartmvp.infrastructure.common.InMemoryRepository
import es.segohe.cartmvp.infrastructure.common.InMemoryRepositoryTest

internal class InMemoryCartRepositoryTest: InMemoryRepositoryTest<Cart, CartId>() {
    override fun getRepository(): InMemoryRepository<Cart, CartId> {
        return InMemoryCartRepository()
    }

    override fun getRandomEntity(): Cart {
        return Cart(CartId())
    }

    override fun changedRandomEntity(entity: Cart): Cart {
        entity.payCart()
        return entity
    }
}
