package es.segohe.cartmvp.domain.common

import java.util.*

open class Id(private val id: String = generateId()) {

    companion object {
        fun generateId() = UUID.randomUUID().toString()
    }

    override fun toString(): String {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Id) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
