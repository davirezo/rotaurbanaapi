package com.rotaurbana.rotaurbanaapi.service;

import com.rotaurbana.rotaurbanaapi.dto.product.ProductRequest;
import com.rotaurbana.rotaurbanaapi.dto.product.ProductResponse;
import com.rotaurbana.rotaurbanaapi.dto.product.ProductVariantRequest;
import com.rotaurbana.rotaurbanaapi.entity.Category;
import com.rotaurbana.rotaurbanaapi.entity.Product;
import com.rotaurbana.rotaurbanaapi.entity.ProductVariant;
import com.rotaurbana.rotaurbanaapi.exception.ApiException;
import com.rotaurbana.rotaurbanaapi.exception.ResourceNotFoundException;
import com.rotaurbana.rotaurbanaapi.repository.CategoryRepository;
import com.rotaurbana.rotaurbanaapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll(Long categoryId) {
        List<Product> products = categoryId != null
                ? productRepository.findAllByCategoryIdOrderByNameAsc(categoryId)
                : productRepository.findAll();

        return products.stream()
                .map(ProductResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        return ProductResponse.from(findProductOrThrow(id));
    }

    @Transactional
    public ProductResponse create(ProductRequest request) {
        Category category = findCategoryOrThrow(request.categoryId());
        validateVariants(request.variants());

        Product product = new Product(request.name(), request.description(), request.imageUrl(), category);
        product.replaceVariants(toVariantEntities(request.variants()));

        return ProductResponse.from(productRepository.save(product));
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = findProductOrThrow(id);
        Category category = findCategoryOrThrow(request.categoryId());
        validateVariants(request.variants());

        product.update(request.name(), request.description(), request.imageUrl(), category);
        product.replaceVariants(toVariantEntities(request.variants()));

        return ProductResponse.from(productRepository.saveAndFlush(product));
    }

    private void validateVariants(List<ProductVariantRequest> variants) {
        for (ProductVariantRequest variant : variants) {
            if (variant.promotionalPrice() != null
                    && variant.promotionalPrice().compareTo(variant.price()) >= 0) {
                throw new ApiException(
                        "Promotional price must be less than the regular price for size '%s'"
                                .formatted(variant.size()),
                        HttpStatus.BAD_REQUEST
                );
            }
        }
    }

    private List<ProductVariant> toVariantEntities(List<ProductVariantRequest> variants) {
        return variants.stream()
                .map(v -> new ProductVariant(v.size(), v.price(), v.promotionalPrice()))
                .toList();
    }

    private Product findProductOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
    }

    private Category findCategoryOrThrow(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", categoryId));
    }
}
