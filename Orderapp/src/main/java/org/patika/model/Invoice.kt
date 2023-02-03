package org.patika.model

data class Invoice(
    val order: Order,
    val total: Int,
    val customer: Customer,
) : BaseEntity(){
    override fun toString(): String {
        return "Invoice --> { customer = $customer, total=$total}"
    }
}