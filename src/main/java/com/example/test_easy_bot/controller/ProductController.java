package com.example.test_easy_bot.controller;

import com.example.test_easy_bot.infrastructure.ProductChangeRequest;
import com.example.test_easy_bot.infrastructure.ProductCreationRequest;
import com.example.test_easy_bot.model.entity.ProductEntity;
import com.example.test_easy_bot.model.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create the product")
    @PostMapping("/product/create")
    public ResponseEntity<Object> createProduct(@RequestBody @Valid ProductCreationRequest productCreationRequest) {
        productService.createProduct(productCreationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Change the product")
    @PostMapping("/product/change")
    public ResponseEntity<Object> changeProduct(@RequestBody @Valid ProductChangeRequest productChangeRequest) {
        productService.changeProduct(productChangeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Get all products")
    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        final List<ProductEntity> products = productService.getAllProducts();
        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Get the product")
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable(name = "id") Integer id) {
        final ProductEntity product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Operation(summary = "Delete the product")
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Integer id) {
        final boolean isDeleted = productService.deleteProductById(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
