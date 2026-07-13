package com.rotaurbana.rotaurbanaapi.dto.category;

import com.rotaurbana.rotaurbanaapi.entity.Category;

import java.time.LocalDateTime;

public record CategoryResponse(
        Long id,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static CategoryResponse from(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.isActive(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }
}
