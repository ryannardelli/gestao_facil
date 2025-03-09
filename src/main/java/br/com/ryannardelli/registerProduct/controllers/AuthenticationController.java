package br.com.ryannardelli.registerProduct.controllers;

import br.com.ryannardelli.registerProduct.Models.AuthenticateDTO;
import br.com.ryannardelli.registerProduct.Models.RegisterDTO;
import br.com.ryannardelli.registerProduct.Models.User;
import br.com.ryannardelli.registerProduct.dto.LoginResponseDTO;
import br.com.ryannardelli.registerProduct.infra.security.TokenService;
import br.com.ryannardelli.registerProduct.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticateDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if (data.email() != null && this.userRepository.findByEmail(data.email()).isPresent()) {
            return ResponseEntity.badRequest().build();
        } else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            var user = new User(data.name(), data.email(), encryptedPassword, data.role());
            this.userRepository.save(user);
            System.out.println("Dados: " +user);
            return ResponseEntity.ok().build();
        }
    }
}
