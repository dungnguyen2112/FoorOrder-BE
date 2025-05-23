package com.example.cosmeticsshop.controller;

import com.example.cosmeticsshop.domain.Category;
import com.example.cosmeticsshop.domain.Product;
import com.example.cosmeticsshop.domain.request.ReqProductDTO;
import com.example.cosmeticsshop.domain.response.ResCategoryDTO;
import com.example.cosmeticsshop.domain.response.ResProductDTO;
import com.example.cosmeticsshop.domain.response.ResultPaginationDTO;
import com.example.cosmeticsshop.service.CategoryService;
import com.example.cosmeticsshop.util.annotation.ApiMessage;
import com.example.cosmeticsshop.util.error.IdInvalidException;
import com.turkraft.springfilter.boot.Filter;

import jakarta.validation.Valid;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Lấy thông tin Category theo ID
    @GetMapping("/categories/{id}")
    @ApiMessage("Get a category by ID")
    public ResponseEntity<ResCategoryDTO> getCategoryById(@PathVariable Long id) {
        ResCategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/categories")
    @ApiMessage("Get all categories")
    public List<String> getAllCategoriesName() {
        List<String> categories = categoryService.getAllCategoriesName();
        return categories;
    }

    @PostMapping("/categories")
    @ApiMessage("Create a new category")
    public ResponseEntity<ResCategoryDTO> createNewProduct(@Valid @RequestBody Category postManProduct)
            throws IdInvalidException {
        Category category = categoryService.createCategory(postManProduct);
        ResCategoryDTO resCategoryDTO = categoryService.convertCategorytDto(category);
        return ResponseEntity.ok(resCategoryDTO);

    }

    @PutMapping("/categories/{id}")
    @ApiMessage("Update a category")
    public ResponseEntity<ResCategoryDTO> updateCategory(@PathVariable Long id,
            @Valid @RequestBody Category postManProduct)
            throws IdInvalidException {
        Category category = categoryService.updateCategory(id, postManProduct);
        ResCategoryDTO resCategoryDTO = categoryService.convertCategorytDto(category);
        return ResponseEntity.ok(resCategoryDTO);
    }

    @DeleteMapping("/categories/{id}")
    @ApiMessage("Delete a category")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categories/pagination")
    @ApiMessage("Get all categories with pagination")
    public ResponseEntity<ResultPaginationDTO> getAllProducts(@Filter Specification<Category> spec,
            @ParameterObject Pageable pageable) {

        ResultPaginationDTO result = this.categoryService.fetchAllCategory(spec, pageable);
        return ResponseEntity.ok(result);

    }
}
