package org.patika.service;

import org.patika.enums.Industry;
import org.patika.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CustomerService {
    private final List<Customer> listOfCustomer = new ArrayList<>();

    public void createCustomer(String name){
        Random rand = new Random();
        Industry industry = Industry.values()[rand.nextInt(Industry.values().length)];
        Customer customer = new Customer(name,industry);
        listOfCustomer.add(customer);
    }

    public List<Customer> getAllCustomer(){
        return listOfCustomer;
    }


    public Customer findCustomerById(String id){
        Optional<Customer> customer =
                listOfCustomer.stream()
                        .filter(c-> c.getId().equals(id)).findFirst();
        if(customer.isEmpty())
            System.out.println("hatattatata");
        return customer.get();
    }




}
