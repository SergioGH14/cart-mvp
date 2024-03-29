package es.segohe.cartmvp.infrastructure.repository

import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.id.CartId
import es.segohe.cartmvp.domain.repositoy.CartRepository
import es.segohe.cartmvp.infrastructure.common.InMemoryRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryCartRepository: InMemoryRepository<Cart, CartId>(), CartRepository
