package com.bootcamp.EcommerceBackend.repository;

import com.bootcamp.EcommerceBackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
