package com.rotaurbana.rotaurbanaapi.dto.product;

import com.rotaurbana.rotaurbanaapi.dto.category.CategorySummary;
import com.rotaurbana.rotaurbanaapi.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String description,
        String imageUrl,
        CategorySummary category,
        List<ProductVariantResponse> variants,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImageUrl(),
                CategorySummary.from(product.getCategory()),
                product.getVariants().stream()
                        .map(ProductVariantResponse::from)
                        .toList(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
