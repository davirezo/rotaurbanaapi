package com.rotaurbana.rotaurbanaapi.dto.category;

import com.rotaurbana.rotaurbanaapi.entity.Category;

public record CategorySummary(Long id, String name) {

    public static CategorySummary from(Category category) {
        return new CategorySummary(category.getId(), category.getName());
    }
}
