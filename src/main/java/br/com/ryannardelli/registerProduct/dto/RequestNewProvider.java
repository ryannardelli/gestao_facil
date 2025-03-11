package br.com.ryannardelli.registerProduct.dto;

import br.com.ryannardelli.registerProduct.Models.Provider;
import jakarta.validation.constraints.NotBlank;

public class RequestNewProvider {
    @NotBlank(message = "O nome é obrigatório.")
    private String name; // Alterado de nameProvider para name

    @NotBlank(message = "O CNPJ é obrigatório.")
    private String cnpj;

    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    private String phone;

    @NotBlank(message = "O Endereço é obrigatório.")
    private String address;

    public RequestNewProvider() {}

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

    public Provider toProvider() {
        Provider provider = new Provider();
        provider.setName(name);
        provider.setCnpj(cnpj);
        provider.setEmail(email);
        provider.setPhone(phone);
        provider.setAddress(address);
        return provider;
    }

    public Provider toProvider(Provider provider) {
        provider.setName(this.name);
        provider.setCnpj(this.cnpj);
        provider.setEmail(this.email);
        provider.setPhone(this.phone);
        provider.setAddress(this.address);
        return provider;
    }

    public void fromProvider(Provider provider) {
        this.name = provider.getName();
        this.cnpj = provider.getCnpj();
        this.email = provider.getEmail();
        this.phone = provider.getPhone();
        this.address = provider.getAddress();
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}