package es.segohe.cartmvp.infrastructure.common

import es.segohe.cartmvp.domain.common.Entity
import es.segohe.cartmvp.domain.common.Id
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


abstract class InMemoryRepositoryTest<E : Entity<I>, I : Id> {

    @BeforeEach
    fun clear() {
        getRepository().clear()
    }

    @Test
    fun `given an id from non existing entity returns null`() {
        val id = getRandomEntity().id
        assertNull(getRepository().find(id))
    }

    @Test
    fun `given an id from an existing entity returns entity`() {
        val entity = getRandomEntity()
        val repository = getRepository()
        repository.save(entity)

        assertEquals(entity, repository.find(entity.id))
    }

    @Test
    fun `given an entity with changes then save this changes `() {
        val entity = getRandomEntity()
        val repository = getRepository()
        repository.save(entity)
        val changedEntity = changedRandomEntity(entity)
        repository.save(changedEntity)

        assertEquals(changedEntity, repository.find(entity.id))
    }

    @Test
    fun `given an entity persisted when delete then find return null `() {
        val entity = getRandomEntity()
        val repository = getRepository()

        val id = entity.id
        repository.save(entity)
        assertNotNull(repository.find(id))

        repository.delete(id)
        assertNull(repository.find(id))
    }

    @Test
    fun `given only three entities persisted then findAll return three entities `() {
        val repository = getRepository()

        repeat(3) { repository.save(getRandomEntity()) }
        assertNotNull(repository.findAll())
        assertEquals(3, repository.findAll()!!.size)
    }

    abstract fun getRepository(): InMemoryRepository<E, I>
    abstract fun getRandomEntity(): E
    abstract fun changedRandomEntity(entity: E): E

}
