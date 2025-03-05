package br.com.ryannardelli.registerProduct.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String category;

    private int quantity;
    private long cod;

    @Enumerated(EnumType.STRING)
    private StatusProduct statusProduct;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = true)

    private Provider provider;


    // constructor empty
    public Product() { }

    // constructor
    public Product(String name, BigDecimal price, String category, int quantity, long cod, StatusProduct statusProduct) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.cod = cod;
        this.statusProduct = statusProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProduct statusProduct) {
        this.statusProduct = statusProduct;
    }
}
