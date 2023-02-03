package org.patika.service;

import org.patika.enums.Industry;
import org.patika.model.Customer;
import org.patika.model.Invoice;

import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneralService {


    // List of Customer That Contain Letter C
    public List<Customer> getCustomerThatContainC(List<Customer> customerList){
        return customerList.stream()
                .filter(c-> c.getName().contains("c"))
                .toList();
    }

    // Total Amount Of invoice or Customer That is Sign in June
    public Double totalAmountOfInvoiceForCustomerSignInJune(List<Invoice> invoiceList){
        return invoiceList.stream()
                .filter(a -> a.getOrder().getCustomer().getCreatedAt().getMonth() == Month.JANUARY)
                .mapToDouble(Invoice::getTotal).sum();

    }

    // List Of Customer That have invoices Less Than 500
    public List<Customer> getCustomerThatHasUnderFiveHundredInvoice(List<Invoice> list){
        return list.stream()
                .filter(invoice->invoice.getTotal()<500)
                .map(invoice-> invoice.getOrder().getCustomer())
                .toList();
    }



    // List of Invoices Less Than 1500
    public List<Invoice> getAllInvoiceOver1500(List<Invoice> invoiceList){
        return invoiceList.stream()
                .filter(a->a.getTotal()>1500)
                .toList();
    }


    // Average of Invoices are That Greater Than  500
    public Double getAverageOfInvoicesOver1500(List<Invoice> invoiceList){
        return getAllInvoiceOver1500(invoiceList)
                .stream()
                .mapToDouble(Invoice::getTotal)
                .average().orElse(0);
    }


    // It will find customers industries, that have average of invoces  less than 750 (customers may have multiple invoices in one month)
    public Set<Industry> getCustomersIndustryThatBelow750AverageOfInvoice(List<Invoice> invoiceList){
        return invoiceList.stream()
                .filter(invoice->invoice.getCreatedAt().getMonth()==Month.FEBRUARY)
                .filter(a->getAverageInvoiceForOneUser(invoiceList,a.getCustomer().getId())<750)
                .map(b->  b.getCustomer().getIndustry()).collect(Collectors.toSet());

    }

    private Double  getAverageInvoiceForOneUser(List<Invoice> invoiceList,String id){
       return invoiceList.stream()
               .filter(a-> a.getCustomer().getId().equals(id))
               .mapToDouble(Invoice::getTotal)
               .average().orElse(0);

    }


}
