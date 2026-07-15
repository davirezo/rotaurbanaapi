package com.rotaurbana.rotaurbanaapi.repository;

import com.rotaurbana.rotaurbanaapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoryIdOrderByNameAsc(Long categoryId);
}
