package br.com.ryannardelli.registerProduct.Models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome do fornecedor é obrigatório.")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Size(min = 14, max = 18, message = "O CNPJ deve ter entre 14 e 18 caracteres.")
    @Column(nullable = false, unique = true)
    private String cnpj;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Column(nullable = false)
    private String phone;

    @NotBlank(message = "O endereço é obrigatório.")
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Provider() {}

    public Provider(String name, String cnpj, String email, String phone, String address) {
        this.name = name;
        this.cnpj = cnpj;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
