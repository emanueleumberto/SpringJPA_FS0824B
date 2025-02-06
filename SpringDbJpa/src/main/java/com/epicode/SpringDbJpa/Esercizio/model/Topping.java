package com.epicode.SpringDbJpa.Esercizio.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("topping")
public class Topping extends Article {

    public Topping(int calories, double price, String name) {
        super(name, price, calories);
    }
}
