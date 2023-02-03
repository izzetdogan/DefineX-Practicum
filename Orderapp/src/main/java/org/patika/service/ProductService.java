package org.patika.service;

import org.patika.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final  List<Product> listOfProduct = new ArrayList<>();
    public void createProduct(String name, String  description, int price){
        Product product = new Product(name,description,price);
        listOfProduct.add(product);
    }

    public List<Product> getAllProduct(){
        return this.listOfProduct;
    }

    public Product findProductById(String id){
        Optional<Product> product = listOfProduct.stream()
                .filter(p -> p.getId().equals(id)).findFirst();
        if(product.isEmpty())
            throw  new IllegalArgumentException("sss");
        return product.get();
    }


}
