package com.epicode.SpringDbJpa.Esercizio.repository;

import com.epicode.SpringDbJpa.Esercizio.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAORepository extends JpaRepository<Menu, Long> {
    Menu findByNome(String nome);
}
