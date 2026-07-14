package com.rotaurbana.rotaurbanaapi.controller;

import com.rotaurbana.rotaurbanaapi.dto.category.CategoryRequest;
import com.rotaurbana.rotaurbanaapi.dto.category.CategoryResponse;
import com.rotaurbana.rotaurbanaapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(
            @RequestParam(defaultValue = "false") boolean active
    ) {
        return ResponseEntity.ok(categoryService.findAll(active));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request) {
        CategoryResponse created = categoryService.create(request);
        return ResponseEntity.created(URI.create("/categories/" + created.id())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request
    ) {
        return ResponseEntity.ok(categoryService.update(id, request));
    }
}
