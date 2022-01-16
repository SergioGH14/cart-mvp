package es.segohe.cartmvp.infrastructure.repository

import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.ProductId
import es.segohe.cartmvp.infrastructure.common.InMemoryRepository
import es.segohe.cartmvp.infrastructure.common.InMemoryRepositoryTest

internal class InMemoryProductRepositoryTest : InMemoryRepositoryTest<Product, ProductId>() {
    override fun getRepository(): InMemoryRepository<Product, ProductId> {
        return InMemoryProductRepository()
    }

    override fun getRandomEntity(): Product {
        return Product(ProductId(), Math.random(),"Sample product")
    }

    override fun changedRandomEntity(entity: Product): Product {
        return Product(entity.id, Math.random(),"Sample product")
    }
}
