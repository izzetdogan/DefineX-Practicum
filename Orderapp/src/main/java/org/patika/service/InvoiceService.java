package org.patika.service;

import org.patika.model.Customer;
import org.patika.model.Invoice;
import org.patika.model.Order;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private final List<Invoice> invoiceList = new ArrayList<>();

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public  void createInvoice(Order order, int total , Customer customer){
        Invoice invoice = new Invoice(order,total,customer);
        invoiceList.add(invoice);

    }

}
