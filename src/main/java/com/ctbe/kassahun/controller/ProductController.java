package com.ctbe.kassahun.controller;

import com.ctbe.kassahun.model.Product; 
import com.ctbe.kassahun.service.ProductService; 
import jakarta.validation.Valid; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 
  
@RestController 
@RequestMapping("/products") 
public class ProductController { 
  
    private final ProductService productService; 
  
    public ProductController(ProductService productService) { 
        this.productService = productService; 
    } 
  
    // ── GET /products ──────────────────────────────────────── 
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() { 
        return ResponseEntity.ok(productService.findAll()); 
    } 
  
    // ── GET /products/{id} ─────────────────────────────────── 
    @GetMapping("/{id}") 
    public ResponseEntity<Product> getProductById(@PathVariable Long id) { 
        return productService.findById(id) 
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    } 
  
    // ── POST /products ─────────────────────────────────────── 
    @PostMapping 
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product 
product) { 
        Product saved = productService.save(product); 
        return ResponseEntity.status(HttpStatus.CREATED).body(saved); 
    } 
} 
