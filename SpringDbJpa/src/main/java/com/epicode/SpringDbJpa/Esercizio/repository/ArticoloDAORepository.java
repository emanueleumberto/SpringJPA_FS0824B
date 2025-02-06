package com.epicode.SpringDbJpa.Esercizio.repository;

import com.epicode.SpringDbJpa.Esercizio.model.Article;
import com.epicode.SpringDbJpa.Esercizio.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloDAORepository extends JpaRepository<Article, Long> {
    Topping findByName(String name);
}
