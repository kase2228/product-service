package com.ctbe.kassahun.service;

import com.ctbe.kassahun.dto.ProductRequest;
import com.ctbe.kassahun.dto.ProductResponse;
import com.ctbe.kassahun.exception.ResourceNotFoundException;
import com.ctbe.kassahun.model.Product;
import com.ctbe.kassahun.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service 
public class ProductService { 
  
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // ── Read ─────────────────────────────────────────────────
    public List<ProductResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public ProductResponse findById(Long id) {
        return toResponse(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    // ── Create ───────────────────────────────────────────────
    public ProductResponse create(ProductRequest req) {
        return toResponse(repo.save(toEntity(req)));
    }

    // ── Update ───────────────────────────────────────────────
    public ProductResponse update(Long id, ProductRequest req) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setStockQty(req.getStockQty());
        existing.setCategory(req.getCategory());
        return toResponse(repo.save(existing));
    }

    // ── Delete ───────────────────────────────────────────────
    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException(id);
        repo.deleteById(id);
    }

    // ── Mapping helpers ───────────────────────────────────────
    private ProductResponse toResponse(Product p) {
        return new ProductResponse(p.getId(), p.getName(),
                p.getPrice(), p.getStockQty(), p.getCategory());
    }

    private Product toEntity(ProductRequest req) {
        return new Product(req.getName(), req.getPrice(),
                req.getStockQty(), req.getCategory());
    }
}