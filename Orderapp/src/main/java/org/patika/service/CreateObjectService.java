package org.patika.service;

import org.patika.model.Customer;
import org.patika.model.Order;
import org.patika.model.OrderLineItem;
import org.patika.model.Product;

import java.util.List;
import java.util.Random;
import java.util.Set;


public class CreateObjectService {

    private OrderLineItemService orderLineItemService;

    private  void createProduct(ProductService productService){
        productService.createProduct("product1","desc1",15);
        productService.createProduct("product2", "desc2",20);
        productService.createProduct("product3", "desc3",50);
        productService.createProduct("product4", "4",250);
    }

    private void createCustomer(CustomerService customerService){
        customerService.createCustomer("azat");
        customerService.createCustomer("erhan");
        customerService.createCustomer("ercan");
        customerService.createCustomer("omer");
    }


    public void CreateObject(CustomerService customerService,
                             ProductService productService,
                             OrderLineItemService orderLineItemService,
                             OrderService orderService,
                             InvoiceService invoiceService
    ){
        Random rand = new Random();
        createCustomer(customerService);
        createProduct(productService);

        List<Customer> listOfCustomer = customerService.getAllCustomer();
        List<Product> listOfProduct = productService.getAllProduct();
        Set<OrderLineItem>lineItems = orderLineItemService.getOrderLineItemSet();

        // Product --> OrderLineItem--> Order--> Customer ---> Invoice
        // Create 3 user with order -orderLine and Invoice
        for(int i =0; i<=3; i++){
            orderLineItemService.createOrderLineItem(listOfProduct.get(rand.nextInt(listOfProduct.size())),(i+1)*10);
            orderLineItemService.createOrderLineItem(listOfProduct.get(rand.nextInt(listOfProduct.size())),i*10);
            Order order = orderService.createOrder(listOfCustomer.get(i),lineItems);
            int total = orderLineItemService.totalPrice(lineItems);
            invoiceService.createInvoice(order,total, order.getCustomer());
            orderLineItemService.remove(lineItems);
        }



        // Add another invoice to first customer
        orderLineItemService.createOrderLineItem(listOfProduct.get(rand.nextInt(listOfProduct.size())),10);
        orderLineItemService.createOrderLineItem(listOfProduct.get(rand.nextInt(listOfProduct.size())),10);
        Order order = orderService.createOrder(listOfCustomer.get(0),lineItems);
        int total = orderLineItemService.totalPrice(lineItems);
        invoiceService.createInvoice(order,total, order.getCustomer());





    }




}
