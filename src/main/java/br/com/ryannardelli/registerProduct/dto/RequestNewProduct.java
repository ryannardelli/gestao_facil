package br.com.ryannardelli.registerProduct.dto;

import br.com.ryannardelli.registerProduct.Models.Product;
import br.com.ryannardelli.registerProduct.Models.Provider;
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
    private Long cod;
    @NotNull(message = "O campo quantidade é obrigatório.")
    private Integer quantity;
    @NotNull(message = "Por favor, selecione uma categoria.")
    private StatusProduct statusProduct;

    private String nameProvider;
    private String cnpj;
    private String email;
    private String phone;
    private String address;

    public RequestNewProduct() {
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
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

    public Provider toProvider() {
        Provider provider = new Provider();
        provider.setNameProvider(nameProvider);
        provider.setCnpj(cnpj);
        provider.setEmail(email);
        provider.setAddress(address);
        provider.setPhone(phone);

        return provider;
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