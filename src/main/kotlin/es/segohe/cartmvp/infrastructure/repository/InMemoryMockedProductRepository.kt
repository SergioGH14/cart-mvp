package es.segohe.cartmvp.infrastructure.repository

import org.springframework.stereotype.Repository

@Repository
class InMemoryMockedProductRepository: InMemoryProductRepository() {
    init {
        mockDatabase()
    }
}
