package com.ctbe.kassahun.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive; 
  
@Entity 
@Table(name = "products") 
public class Product { 
  
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
  
    @NotBlank(message = "Product name must not be blank") 
    @Column(nullable = false) 
    private String name; 
  
    @Positive(message = "Price must be greater than zero") 
    @Column(nullable = false) 
    private double price;

    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stockQty;

    @NotBlank(message = "Category is required")
    private String category;

    // ── Constructors ────────────────────────────────────────── 
    public Product() {} 

    public Product(String name, double price, int stockQty, String category) {
        this.name  = name; 
        this.price = price;
        this.stockQty = stockQty;
        this.category = category;
    } 
  
    // ── Getters and Setters ─────────────────────────────────── 
    public Long   getId()            { return id; } 
    public String getName()          { return name; } 
    public double getPrice()         { return price; } 
    public void   setId(Long id)     { this.id = id; } 
    public void   setName(String n)  { this.name = n; } 
    public void   setPrice(double p) { this.price = p; }
    public int    getStockQty()        { return stockQty; }
    public String getCategory()        { return category; }
    public void   setStockQty(int q)   { this.stockQty = q; }
    public void   setCategory(String c){ this.category = c; }
}
