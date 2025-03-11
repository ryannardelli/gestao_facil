package br.com.ryannardelli.registerProduct.repositories;

import br.com.ryannardelli.registerProduct.Models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {}
