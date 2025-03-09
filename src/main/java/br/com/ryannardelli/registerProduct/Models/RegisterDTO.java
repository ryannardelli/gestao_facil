package br.com.ryannardelli.registerProduct.Models;

public record RegisterDTO(String name, String email, String password, UserRole role) {

}
