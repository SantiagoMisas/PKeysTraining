package com.fk.PKeysTrainingJpa.repositories;

import com.fk.PKeysTrainingJpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
