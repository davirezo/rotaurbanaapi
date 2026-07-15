package com.rotaurbana.rotaurbanaapi.dto.product;

import com.rotaurbana.rotaurbanaapi.entity.ProductVariant;

import java.math.BigDecimal;

public record ProductVariantResponse(
        Long id,
        String size,
        BigDecimal price,
        BigDecimal promotionalPrice
) {

    public static ProductVariantResponse from(ProductVariant variant) {
        return new ProductVariantResponse(
                variant.getId(),
                variant.getSize(),
                variant.getPrice(),
                variant.getPromotionalPrice()
        );
    }
}
