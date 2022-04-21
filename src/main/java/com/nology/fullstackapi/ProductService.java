package com.nology.fullstackapi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    @Autowired
    ProductsRepo repository;

    public Product getProduct(Long id) {
        return repository
                .findById(id)
                .orElse(null);
    }



    public List<Product> getAllProducts() {
        return new ArrayList<>(repository.findAll());
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Product updateProduct(Long id, Product product) throws Exception {
        Product productUpdated = repository.findById(id).orElseThrow(() -> new Exception("Product not available to update!"));
        productUpdated.setName(product.getName());
        productUpdated.setPrice(product.getPrice());
        return repository.save(productUpdated);
    }
}








