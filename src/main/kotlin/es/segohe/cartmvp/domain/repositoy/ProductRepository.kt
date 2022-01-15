package es.segohe.cartmvp.domain.repositoy

import es.segohe.cartmvp.domain.common.Repository
import es.segohe.cartmvp.domain.model.Product
import es.segohe.cartmvp.domain.model.id.ProductId

interface ProductRepository : Repository<Product,ProductId>
