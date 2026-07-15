package com.rotaurbana.rotaurbanaapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variants")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, length = 50)
    private String size;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal promotionalPrice;

    public ProductVariant(String size, BigDecimal price, BigDecimal promotionalPrice) {
        this.size = size;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
    }

    void assignTo(Product product) {
        this.product = product;
    }

    public void update(String size, BigDecimal price, BigDecimal promotionalPrice) {
        this.size = size;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
    }
}
