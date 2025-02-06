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
@DiscriminatorValue("topping")
public class Topping extends Article {

    private String name;

    public Topping(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }
}
