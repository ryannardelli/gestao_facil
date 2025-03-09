package br.com.ryannardelli.registerProduct.Models;

public enum UserRole {
    ADMIN, USER;

    private String role;

     String UserRole(String role) {
        this.role = role;
         return role;
     }

    public String getRole() {
         return role;
    }
}
