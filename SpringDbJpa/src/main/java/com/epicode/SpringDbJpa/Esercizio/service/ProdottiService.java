package com.epicode.SpringDbJpa.Esercizio.service;

import com.epicode.SpringDbJpa.Esercizio.model.Article;
import com.epicode.SpringDbJpa.Esercizio.model.Drink;
import com.epicode.SpringDbJpa.Esercizio.model.Pizza;
import com.epicode.SpringDbJpa.Esercizio.model.Topping;
import com.epicode.SpringDbJpa.Esercizio.repository.ArticoloDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProdottiService {

    @Autowired ArticoloDAORepository prodottiDAO;

    @Autowired @Qualifier("topping_tomato") ObjectProvider<Topping> toppingTomatoProvider;
    @Autowired @Qualifier("topping_cheese") ObjectProvider<Topping> toppingCheeseProvider;
    @Autowired @Qualifier("topping_salami") ObjectProvider<Topping> toppingSalamiProvider;
    @Autowired @Qualifier("pizza_margherita") ObjectProvider<Pizza> pizza_margheritaProvider;
    @Autowired @Qualifier("pizza_salami") ObjectProvider<Pizza> pizza_salamiProvider;
    @Autowired @Qualifier("water") ObjectProvider<Drink> waterProvider;
    @Autowired @Qualifier("lemonade") ObjectProvider<Drink> lemonadeProvider;

    public Pizza createPizzaMargherita() {
        Pizza p = pizza_margheritaProvider.getObject();
        p.addTopping(getTopping("Tomato"));
        p.addTopping(getTopping("Cheese"));
        return p;
    }

    public Pizza createPizzaSalami() {
        Pizza p = pizza_salamiProvider.getObject();
        p.addTopping(getTopping("Tomato"));
        p.addTopping(getTopping("Cheese"));
        p.addTopping(getTopping("Salami"));
        return p;
    }

    public Drink createWater() {
        return waterProvider.getObject();
    }

    public Drink createLemonade() {
        return lemonadeProvider.getObject();
    }

    public Topping createToppingTomato() {
        return toppingTomatoProvider.getObject();
    }

    public Topping createToppingCheese() {
        return toppingCheeseProvider.getObject();
    }

    public Topping createToppingSalami() {
        return toppingSalamiProvider.getObject();
    }

    public void salvaProdotto(Article prodotto) {
        prodottiDAO.save(prodotto);
    }

    public Topping getTopping(String name) {
        return prodottiDAO.findByName(name);
    }

}
