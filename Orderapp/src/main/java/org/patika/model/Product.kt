package org.patika.model

data class Product(
    val name: String,
    val description:String,
    val price: Int,
):BaseEntity(){
    override fun toString(): String {
        return "Product "+super.toString() + "(name='$name', description='$description', price=$price)"
    }
}
