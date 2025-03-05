package br.com.ryannardelli.registerProduct.dto;
import br.com.ryannardelli.registerProduct.Models.Provider;

public class RequestNewProvider {
    private String nameProvider;
    private String cnpj;
    private String email;
    private String phone;
    private String address;

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

    public Provider toProvider() {
        Provider provider = new Provider();
        provider.setNameProvider(nameProvider);
        provider.setCnpj(cnpj);
        provider.setEmail(email);
        provider.setPhone(phone);
        return provider;
    }
}
