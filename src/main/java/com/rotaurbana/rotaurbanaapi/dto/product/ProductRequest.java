package com.rotaurbana.rotaurbanaapi.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductRequest(

        @NotBlank(message = "Name is required")
        @Size(max = 150, message = "Name must be at most 150 characters")
        String name,

        @Size(max = 1000, message = "Description must be at most 1000 characters")
        String description,

        String imageUrl,

        @NotNull(message = "Category is required")
        Long categoryId,

        @NotEmpty(message = "At least one variant is required")
        @Valid
        List<ProductVariantRequest> variants
) {
}
