package org.patika.service;

import org.patika.model.OrderLineItem;
import org.patika.model.Product;

import java.util.HashSet;
import java.util.Set;

public class OrderLineItemService {
    private Set<OrderLineItem> orderLineItemSet = new HashSet<>();

    public Set<OrderLineItem> getOrderLineItemSet() {
        return orderLineItemSet;
    }
    public void createOrderLineItem(Product product, int quantity){
        OrderLineItem orderLineItem = new OrderLineItem(product,quantity);
        orderLineItemSet.add(orderLineItem);
    }



    public void remove(Set<OrderLineItem> orderLineItemSet){
        this.orderLineItemSet.removeAll(orderLineItemSet);
    }

    public int totalPrice(Set<OrderLineItem> orderLineItemSet){
        return orderLineItemSet.stream()
                .mapToInt(item->item.getProduct().getPrice()* item.getQuantity())
                .sum();
    }


}
