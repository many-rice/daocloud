package com.powergrid.integration.repository;

import com.powergrid.integration.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    Product findByName(String name);
}
