package com.ctbe.kassahun.repository;

import com.ctbe.kassahun.model.Product; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import java.util.List; 
  
@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> { 
  
    // Spring Data automatically generates the SQL for this method: 
    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findByCategory(String category);
}
