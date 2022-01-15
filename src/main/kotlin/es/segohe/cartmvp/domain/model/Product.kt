package es.segohe.cartmvp.domain.model

import es.segohe.cartmvp.domain.common.Entity
import es.segohe.cartmvp.domain.model.id.ProductId

class Product(id: ProductId, val price: Double, val name: String) : Entity<ProductId>(id) {

    fun toData(): ProductData {
        return ProductData(id.toString(),price,name)
    }

    data class ProductData(val id: String, val price: Double, val name: String)

}
