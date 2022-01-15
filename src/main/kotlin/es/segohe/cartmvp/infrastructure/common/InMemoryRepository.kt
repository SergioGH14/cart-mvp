package es.segohe.cartmvp.infrastructure.common

import es.segohe.cartmvp.domain.common.Entity
import es.segohe.cartmvp.domain.common.Id
import es.segohe.cartmvp.domain.common.Repository

abstract class InMemoryRepository<E: Entity<I>, I: Id> : Repository<E, I> {

    protected val database = mutableMapOf<I,E>()

    override fun find(id: I): E? {
        return database[id]
    }

    override fun findAll(): List<E>? {
        return database.values.toList()
    }

    override fun save(data: E) {
        database[data.id] = data
    }

    override fun delete(id: I) {
        database.remove(id)
    }

    fun clear(){
        database.clear()
    }
}
