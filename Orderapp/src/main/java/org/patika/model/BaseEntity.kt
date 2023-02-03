package org.patika.model

import java.time.LocalDate
import java.util.*

//All models  will be inherited from this class to have id and created date
abstract class BaseEntity @JvmOverloads constructor(
    var id: String= UUID.randomUUID().toString(),
    var createdAt: LocalDate= LocalDate.now()
){
    override fun toString(): String {
        return " id='$id', createdAt=$createdAt "
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}