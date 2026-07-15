package com.rotaurbana.rotaurbanaapi.repository;

import com.rotaurbana.rotaurbanaapi.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
