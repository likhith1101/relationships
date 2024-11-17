package com.practise.relationships.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.relationships.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
