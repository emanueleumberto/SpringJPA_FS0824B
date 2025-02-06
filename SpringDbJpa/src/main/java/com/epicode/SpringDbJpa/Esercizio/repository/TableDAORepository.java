package com.epicode.SpringDbJpa.Esercizio.repository;

import com.epicode.SpringDbJpa.Esercizio.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDAORepository extends JpaRepository<Table, Long> {
    Table findByNumTable(int num);
}
