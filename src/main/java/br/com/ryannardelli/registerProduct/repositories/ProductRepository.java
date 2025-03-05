package br.com.ryannardelli.registerProduct.repositories;

import br.com.ryannardelli.registerProduct.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
