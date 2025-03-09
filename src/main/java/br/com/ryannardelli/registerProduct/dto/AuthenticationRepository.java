package br.com.ryannardelli.registerProduct.dto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import br.com.ryannardelli.registerProduct.Models.User;

public interface AuthenticationRepository extends JpaRepository<User, String> {
    UserDetails findByEmail(String email);
}
