package com.example.cosmeticsshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cosmeticsshop.domain.response.DashboardDTO;
import com.example.cosmeticsshop.service.CategoryService;
import com.example.cosmeticsshop.service.OrderService;
import com.example.cosmeticsshop.service.ProductService;
import com.example.cosmeticsshop.service.ResTableService;
import com.example.cosmeticsshop.util.annotation.ApiMessage;

@RestController
@RequestMapping("/api/v1")
public class DashboardController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ResTableService resTableService;

    public DashboardController(CategoryService categoryService, ProductService productService,
            OrderService orderService, ResTableService resTableService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.orderService = orderService;
        this.resTableService = resTableService;
    }

    @GetMapping("/database/dashboard")
    @ApiMessage("Get all data for dashboard")
    public DashboardDTO getDashboardData() {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setTotalCategories(categoryService.getTotalCategories());
        dashboardDTO.setTotalProducts(productService.getTotalProducts());
        dashboardDTO.setTotalOrders(orderService.getTotalOrders());
        dashboardDTO.setTotalTables(resTableService.getTotalAvailableTables());
        return dashboardDTO;
    }

}
