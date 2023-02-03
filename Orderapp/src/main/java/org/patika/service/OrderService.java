package org.patika.service;

import org.patika.model.Customer;
import org.patika.model.Order;
import org.patika.model.OrderLineItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderService {
    private final List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public Order createOrder(Customer customer, Set<OrderLineItem> orderLineItemSet){
        Order order = new Order(customer,orderLineItemSet);
        orderList.add(order);
        return order;
    }

}
