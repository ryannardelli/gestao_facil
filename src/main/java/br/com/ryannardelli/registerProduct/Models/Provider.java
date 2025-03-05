package br.com.ryannardelli.registerProduct.Models;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    private String name;
    private String cnpj;
    private String email;
    private String phone;
    private String address;

    public Provider() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String getNameProvider() {
        return name;
    }

    public void setNameProvider(String name) {
        this.name = name;
    }

    public void getCnpj() {
        this.cnpj = cnpj;
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

    public void getAddress() {
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
