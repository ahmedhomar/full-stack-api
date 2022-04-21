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
    public ResponseEntity<Product> getProductsById(@RequestParam Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(service.getProduct(id));
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllProducts());

    }

    @PostMapping(path = "/")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addProduct(product));
    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateProduct(id, product));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(id));
    }
}


