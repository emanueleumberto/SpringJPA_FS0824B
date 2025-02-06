package com.epicode.SpringDbJpa.Esercizio.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("drink")
public class Drink extends Article {

    private String name;

    public Drink(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }
}
