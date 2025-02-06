package com.epicode.SpringDbJpa.Esercizio.repository;

import com.epicode.SpringDbJpa.Esercizio.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAORepository extends JpaRepository<Order, Long> {
}
