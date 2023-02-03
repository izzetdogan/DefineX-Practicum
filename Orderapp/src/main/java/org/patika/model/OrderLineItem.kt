package org.patika.model

data class OrderLineItem(
    val product: Product,
    val quantity: Int,
)
{
    override fun toString(): String {
        return "{$product, quantity=$quantity}\n"
    }
}