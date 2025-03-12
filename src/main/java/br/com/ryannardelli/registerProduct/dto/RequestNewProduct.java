package br.com.ryannardelli.registerProduct.dto;

import br.com.ryannardelli.registerProduct.Models.Product;
import br.com.ryannardelli.registerProduct.Models.StatusProduct;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

// Class DTO (Data Transfer Object)
public class RequestNewProduct {
    @NotBlank(message = "O campo nome é obrigatório.")
    private String name;
    @NotNull(message = "O campo preço é obrigatório.")
    @DecimalMin("0.0")
    private BigDecimal price;
    @NotBlank(message = "O campo categoria é obrigatório.")
    private String category;
    @NotNull(message = "O campo código é obrigatório.")
    private String cod;
    @NotNull(message = "O campo quantidade é obrigatório.")
    private Integer quantity;
    @NotNull(message = "Por favor, selecione uma categoria.")
    private StatusProduct statusProduct;

    public RequestNewProduct() {}

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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public StatusProduct getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(StatusProduct statusProduct) {
        this.statusProduct = statusProduct;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setQuantity(quantity);
        product.setCod(cod);
        product.setStatusProduct(statusProduct);

        return product;
    }

    public Product toProduct(Product product) {
        product.setName(this.name);
        product.setPrice(this.price);
        product.setQuantity(this.quantity);
        product.setCod(this.cod);
        product.setCategory(this.category);
        product.setStatusProduct(this.statusProduct);
        return product;
    }

    public void fromProduct(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.quantity = product.getQuantity();
        this.cod = product.getCod();
        this.statusProduct = product.getStatusProduct();
    }

    @Override
    public String toString() {
        return "RequestNewProduct{" +
                "productName='" + name + '\'' +
                " productPrice=" + price +
                " productCode=" + cod +
                " quantity=" + quantity +
                " productCategory='" + category + '\'' +
                " statusProduct=" + statusProduct +
                '}';
    }
}