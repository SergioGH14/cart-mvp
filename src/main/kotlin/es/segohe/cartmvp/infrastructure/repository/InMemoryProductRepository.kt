package es.segohe.cartmvp.infrastructure.repository

import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.ProductId
import es.segohe.cartmvp.infrastructure.common.InMemoryRepository
import org.springframework.stereotype.Repository

class InMemoryProductRepository : InMemoryRepository<Product, ProductId>()
