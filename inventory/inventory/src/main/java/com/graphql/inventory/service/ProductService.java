package com.graphql.inventory.service;

import com.graphql.inventory.model.Product;
import com.graphql.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }


    // update
    public Product updateProduct(int id, int stock){
        Product existingProduct = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found" +id));
        existingProduct.setStock(stock);
        return  repository.save(existingProduct);
    }

    //receive new shipment
    public Product receiveNewShipment(int id, int quantity){

        Product existingProduct = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found" +id));

        existingProduct.setStock(existingProduct.getStock() + quantity);
        return  repository.save(existingProduct);
    }
}
