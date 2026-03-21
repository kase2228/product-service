package com.ctbe.kassahun;

import com.ctbe.kassahun.model.Product; 
import com.ctbe.kassahun.repository.ProductRepository; 
import com.ctbe.kassahun.service.ProductService; 
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import org.mockito.junit.jupiter.MockitoExtension; 
import java.util.Optional; 
  
import static org.assertj.core.api.Assertions.assertThat; 
import static org.mockito.Mockito.when; 
  
@ExtendWith(MockitoExtension.class) 
class ProductServiceTest { 
  
    @Mock 
    private ProductRepository productRepository;  // fake database 
  
    @InjectMocks 
    private ProductService productService;        // class under test 
  
    @Test 
    void findById_returnsProduct_whenProductExists() { 
        // Arrange — define what the mock should return 
        Product laptop = new Product("Laptop", 1200.0); 
        laptop.setId(1L); 
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop)); 
  
        // Act — call the method under test 
        Optional<Product> result = productService.findById(1L); 
  
        // Assert — verify the result 
        assertThat(result).isPresent(); 
        assertThat(result.get().getName()).isEqualTo("Laptop"); 
        assertThat(result.get().getPrice()).isEqualTo(1200.0); 
    } 
  
    @Test 
    void findById_returnsEmpty_whenProductNotFound() { 
        when(productRepository.findById(99L)).thenReturn(Optional.empty()); 
  
        Optional<Product> result = productService.findById(99L); 
  
        assertThat(result).isEmpty(); 
    } 
} 
