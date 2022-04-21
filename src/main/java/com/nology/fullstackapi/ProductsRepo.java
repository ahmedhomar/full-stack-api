package com.nology.fullstackapi;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductsRepo extends JpaRepository<Product, Long> {


}
