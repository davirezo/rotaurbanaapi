package com.rotaurbana.rotaurbanaapi.dto.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductVariantRequest(

        @NotBlank(message = "Size is required")
        String size,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
        BigDecimal price,

        @DecimalMin(value = "0.0", inclusive = false, message = "Promotional price must be greater than zero")
        BigDecimal promotionalPrice
) {
}
