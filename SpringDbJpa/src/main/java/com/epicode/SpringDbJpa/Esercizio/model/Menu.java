package com.epicode.SpringDbJpa.Esercizio.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    private long id;
    private String nome;

    @OneToMany(mappedBy = "menu")
    private List<Article> menuList = new ArrayList<Article>();

    public void printMenu() {
        System.out.println("---------- Menu --------");
        //this.menuList.forEach(ele -> System.out.println(ele));
        System.out.println("Pizzas");
        this.menuList.forEach(ele -> {
            if(ele instanceof Pizza) {
                System.out.print(((Pizza) ele).getName() + " - ");
                System.out.print(((Pizza) ele).getCalories() + " - ");
                System.out.println(((Pizza) ele).getPrice());
            }
        });
        System.out.println("Toppings");
        this.menuList.forEach(ele -> {
            if(ele instanceof Topping) {
                System.out.print(((Topping) ele).getName() + " - ");
                System.out.print(((Topping) ele).getCalories() + " - ");
                System.out.println(((Topping) ele).getPrice());
            }
        });
        System.out.println("Drinks");
        this.menuList.forEach(ele -> {
            if(ele instanceof Drink) {
                System.out.print(((Drink) ele).getName() + " - ");
                System.out.print(((Drink) ele).getCalories() + " - ");
                System.out.println(((Drink) ele).getPrice());
            }
        });
    }
}
