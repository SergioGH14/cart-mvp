package es.segohe.cartmvp.domain.repositoy

import es.segohe.cartmvp.domain.common.Repository
import es.segohe.cartmvp.domain.model.Cart
import es.segohe.cartmvp.domain.model.id.CartId

interface CartRepository : Repository<Cart,CartId>
