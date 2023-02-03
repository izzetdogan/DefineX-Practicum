package org.patika.model

data class Order(
    val customer: Customer,
    val orderLineItem: Set<OrderLineItem>,
): BaseEntity()
{
    override fun toString(): String {
        return "Order {customer=$customer, \norderLineItem=$orderLineItem }"
    }
}
