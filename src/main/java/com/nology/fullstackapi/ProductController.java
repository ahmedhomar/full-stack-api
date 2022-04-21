package com.nology.fullstackapi;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping(path = "/{id}")
    public Product getProducts(@PathVariable Long id) {
        return service.getProduct(id);
    }


    @GetMapping(path = "/")
    public List<Product> getProducts() {
        return service.getProduct();
    }


    @GetMapping(path = "/")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }


    @PostMapping(path = "/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addProduct(product));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, product));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(id));
    }
}


