package es.segohe.cartmvp.domain.model

import es.segohe.cartmvp.domain.common.Entity
import es.segohe.cartmvp.domain.model.id.CartId

class Cart(id:CartId) : Entity<CartId>(id){

    private var isPaid = false

    fun payCart(){
        isPaid = true
    }

}
