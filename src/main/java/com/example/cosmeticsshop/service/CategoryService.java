package com.example.cosmeticsshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.cosmeticsshop.domain.Category;
import com.example.cosmeticsshop.domain.Order;
import com.example.cosmeticsshop.domain.Product;
import com.example.cosmeticsshop.domain.response.ResCategoryDTO;
import com.example.cosmeticsshop.domain.response.ResultPaginationDTO;
import com.example.cosmeticsshop.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    public ResultPaginationDTO fetchAllCategory(Specification<Category> spec, Pageable pageable) {
        Page<Category> pageCategory = this.categoryRepository.findAll(spec, pageable);
        ResultPaginationDTO rs = new ResultPaginationDTO();
        ResultPaginationDTO.Meta mt = new ResultPaginationDTO.Meta();

        mt.setPage(pageable.getPageNumber() + 1);
        mt.setPageSize(pageable.getPageSize());
        mt.setPages(pageCategory.getTotalPages());
        mt.setTotal(pageCategory.getTotalElements());

        rs.setMeta(mt);

        // Remove sensitive data
        List<Category> listCategory = pageCategory.getContent()
                .stream()
                .map(category -> {
                    Category c = new Category();
                    c.setId(category.getId());
                    c.setName(category.getName());
                    c.setDescription(category.getDescription());
                    c.setImage(category.getImage());
                    return c;
                })
                .collect(Collectors.toList());

        rs.setResult(listCategory);

        return rs;
    }

    public List<String> getAllCategoriesName() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    public ResCategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id).map(this::convertCategoryToResCategoryDTO)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public ResCategoryDTO convertCategoryToResCategoryDTO(Category category) {
        ResCategoryDTO resCategoryDTO = new ResCategoryDTO();
        resCategoryDTO.setId(category.getId());
        resCategoryDTO.setName(category.getName());
        resCategoryDTO.setDescription(category.getDescription());
        resCategoryDTO.setImage(category.getImage());
        return resCategoryDTO;
    }

    public ResCategoryDTO convertCategorytDto(Category category) {
        ResCategoryDTO resCategoryDTO = new ResCategoryDTO();
        resCategoryDTO.setId(category.getId());
        resCategoryDTO.setName(category.getName());
        resCategoryDTO.setDescription(category.getDescription());
        resCategoryDTO.setImage(category.getImage());
        return resCategoryDTO;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(categoryDetails.getName());
            category.setDescription(categoryDetails.getDescription());
            category.setImage(categoryDetails.getImage());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Long getTotalCategories() {
        return categoryRepository.count();
    }

}