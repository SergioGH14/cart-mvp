package es.segohe.cartmvp.domain.common

open class Entity<I : Id>(open val id: I) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Entity<*>) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

