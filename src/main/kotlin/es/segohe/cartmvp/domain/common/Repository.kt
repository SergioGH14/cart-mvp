package es.segohe.cartmvp.domain.common

interface Repository<E : Entity<I>, I : Id> {
    fun find(id: I): E?
    fun findAll(): List<E>?
    fun save(data: E)
    fun delete(id: I)
}
