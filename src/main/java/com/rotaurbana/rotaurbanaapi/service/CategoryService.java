package com.rotaurbana.rotaurbanaapi.service;

import com.rotaurbana.rotaurbanaapi.dto.category.CategoryRequest;
import com.rotaurbana.rotaurbanaapi.dto.category.CategoryResponse;
import com.rotaurbana.rotaurbanaapi.entity.Category;
import com.rotaurbana.rotaurbanaapi.exception.DuplicateResourceException;
import com.rotaurbana.rotaurbanaapi.exception.ResourceNotFoundException;
import com.rotaurbana.rotaurbanaapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll(boolean onlyActive) {
        List<Category> categories = onlyActive
                ? categoryRepository.findAllByActiveTrueOrderByNameAsc()
                : categoryRepository.findAll();

        return categories.stream()
                .map(CategoryResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoryResponse findById(Long id) {
        return CategoryResponse.from(findCategoryOrThrow(id));
    }

    @Transactional
    public CategoryResponse create(CategoryRequest request) {
        if (categoryRepository.existsByNameIgnoreCase(request.name())) {
            throw new DuplicateResourceException("Category", "name", request.name());
        }

        Category category = new Category(request.name());
        if (request.active() != null) {
            category.update(null, request.active());
        }

        return CategoryResponse.from(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = findCategoryOrThrow(id);

        if (request.name() != null && categoryRepository.existsByNameIgnoreCaseAndIdNot(request.name(), id)) {
            throw new DuplicateResourceException("Category", "name", request.name());
        }

        category.update(request.name(), request.active());
        return CategoryResponse.from(categoryRepository.saveAndFlush(category));
    }

    private Category findCategoryOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }
}
