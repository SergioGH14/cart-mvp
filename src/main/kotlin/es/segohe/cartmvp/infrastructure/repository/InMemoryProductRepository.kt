package es.segohe.cartmvp.infrastructure.repository

import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.ProductId
import es.segohe.cartmvp.domain.repositoy.ProductRepository
import es.segohe.cartmvp.infrastructure.common.InMemoryRepository
import org.springframework.stereotype.Repository
import java.lang.Math.random


open class InMemoryProductRepository : InMemoryRepository<Product, ProductId>(), ProductRepository {
    final fun mockDatabase(){
        repeat(50) { database[ProductId(it.toString())] = Product(ProductId(it.toString()), random(),"Sample product $it")}
    }
}
