package org.patika;


import org.patika.model.*;
import org.patika.service.*;

import java.util.*;

public class Main {



    public static void menu(){
        System.out.println("1. Create Customer");
        System.out.println("2. View All User");
        System.out.println("3. View All User That Contain C in Their Name");
        System.out.println("4. View the list of total amount of invoices for customers who signed up in June");
        System.out.println("5. View All Invoice");
        System.out.println("6. List invoices over 1500 TL in the system");
        System.out.println("7. Average over 1500 TL in the system");
        System.out.println("8. get Customers name  That have invoice under 500 TL in the system");
        System.out.println("9 Add Product to Order By Product Id ");
        System.out.println("10. View Product");
        System.out.println("11. View OrderLine");
        System.out.println("12. View Order");
        System.out.println("13. Show industry of invoices that average of bill is less than 750");
        System.out.println("14. Exit");
        System.out.print("Enter your choice: ");
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // initialize All Services
        CreateObjectService createObjectService = new CreateObjectService();
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        OrderLineItemService orderLineItemService = new OrderLineItemService();
        OrderService orderService = new OrderService();
        InvoiceService invoiceService = new InvoiceService();
        GeneralService generalService = new GeneralService();

        // Create object when main method runs
        createObjectService.CreateObject(
                customerService,
                productService,orderLineItemService,
                orderService,invoiceService);



        // Get Lists from Service

        List<Invoice> invoices = invoiceService.getInvoiceList();
        List<Customer> customers = customerService.getAllCustomer();

        //Display,create,calculate for user
        while (true){
            menu();
            int choice = input.nextInt();
            input.nextLine();

            // Create Customer with random industry
            if (choice == 1) {
                System.out.print("Enter customer name: ");
                String customerName = input.nextLine();
                customerService.createCustomer(customerName);
                customerService.getAllCustomer()
                        .forEach(System.out::println);

            } else if (choice == 2) {
                System.out.println("-------------------View Customer----------------------");
                customerService.getAllCustomer()
                        .forEach(System.out::println);
            } else if (choice == 3) {
                System.out.println("-------------------View All User That Contain C in Their Name----------------------");
                generalService.getCustomerThatContainC(customers)
                        .forEach(System.out::println);
            } else if (choice == 4) {
                System.out.println("-----------------------View the list of total amount of invoice for customers who signed up in June----------");
                System.out.println(generalService.totalAmountOfInvoiceForCustomerSignInJune(invoices));
            } else if (choice==5) {
                System.out.println("-------------------View All Invoice----------------------");
                invoiceService.getInvoiceList().forEach(System.out::println);
            } else if(choice==6){
                System.out.println("-------------------List invoices over 1500 TL in the system----------------------");
                generalService.getAllInvoiceOver1500(invoices).forEach(System.out::println);
            } else if (choice==7) {
                System.out.println("-------------------Avergae over 1500 TL in the system----------------------");
                System.out.println(generalService.getAverageOfInvoicesOver1500(invoices));
            } else if (choice==8) {
                System.out.println("-------------------get Customer That have invoice under 500 TL in the system----------------------");
                generalService.getCustomerThatHasUnderFiveHundredInvoice(invoices)
                        .forEach(System.out::println);
            } else if (choice==9) {
                //orderLineItemService.clearOrderLineItem();
                System.out.println("-------------------Add Product to Order By Product Id ----------------------");
                System.out.println("Enter Customer Id to give order");
                String customerId = input.nextLine();

                Customer findCustomer = customerService.findCustomerById(customerId);

                System.out.println("Enter product id for order");
                String productId = input.nextLine();
                Product findProduct = productService.findProductById(productId);


                System.out.println("Enter quantity for order");
                int quantity = input.nextInt();


                Set<OrderLineItem> orderLineItemSet = orderLineItemService.getOrderLineItemSet();
                orderLineItemService.remove(orderLineItemSet);
                orderLineItemService.createOrderLineItem(findProduct,quantity);
                Order order2 = orderService.createOrder(findCustomer,orderLineItemSet);
                int total2 = orderLineItemService.totalPrice(orderLineItemSet);
                invoiceService.createInvoice(order2,total2, order2.getCustomer());

            } else if (choice==10) {
                System.out.println("-------------------View Product----------------------");
                productService.getAllProduct().forEach(System.out::println);

            } else if (choice==11) {
                System.out.println("-------------------View OrderLines----------------------");
                orderLineItemService.getOrderLineItemSet().forEach(System.out::println);
            } else if (choice==12) {
                System.out.println("------------------View Order----------------");
                orderService.getOrderList().forEach(System.out::println);
            } else if(choice==13) {
                generalService.getCustomersIndustryThatBelow750AverageOfInvoice(invoices)
                        .forEach(System.out::println);
            }else{
                System.out.println("Exiting...");
                break;
            }

        }


    }


}