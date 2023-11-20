package com.fk.PKeysTrainingJpa.repositories;

import com.fk.PKeysTrainingJpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
