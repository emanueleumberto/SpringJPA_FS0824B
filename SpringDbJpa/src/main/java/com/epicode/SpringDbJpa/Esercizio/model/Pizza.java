package com.epicode.SpringDbJpa.Esercizio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends Article {

    private String name;
    @ManyToMany
    @JoinTable(
            name = "topping_pizza",
            joinColumns = @JoinColumn(name = "pazza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppingList = new ArrayList<Topping>();

    public void addTopping(Topping t) {
        this.toppingList.add(t);
    }

    public Pizza(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }
}
