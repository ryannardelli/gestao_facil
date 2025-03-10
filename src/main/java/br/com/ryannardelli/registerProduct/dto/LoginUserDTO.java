package br.com.ryannardelli.registerProduct.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDTO {
    @NotBlank(message = "O e-mail não pode ficar em branco.")
    private String email;

    @NotBlank(message = "A senha não pode ficar em branco.")
    private String password;

    public LoginUserDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestNewProduct{" +
                "email='" + email + '\'' +
                " password=" + password +
                '}';
    }

}
