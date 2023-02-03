package org.patika.model

import org.patika.enums.Industry

data class Customer (
    val name: String,
    val industry: Industry,

) : BaseEntity(){

    override fun toString(): String {
        return "Customer(name='$name', industry=$industry) "+ super.toString();
    }


}
