package com.ctbe.kassahun.service;

import com.ctbe.kassahun.model.Product; 
import com.ctbe.kassahun.repository.ProductRepository; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import java.util.Optional; 
  
@Service 
public class ProductService { 
  
    private final ProductRepository productRepository; 
  
    // Constructor injection — preferred over @Autowired on a field 
    public ProductService(ProductRepository productRepository) { 
        this.productRepository = productRepository; 
    } 
  
    /** Return all products from the database. */ 
    public List<Product> findAll() { 
        return productRepository.findAll(); 
    } 
  
    /** Return a single product by ID, or empty if not found. */ 
    public Optional<Product> findById(Long id) { 
        return productRepository.findById(id); 
    } 
  
    /** Persist a new or updated product and return the saved entity. */ 
    public Product save(Product product) { 
        return productRepository.save(product); 
    } 
} 
