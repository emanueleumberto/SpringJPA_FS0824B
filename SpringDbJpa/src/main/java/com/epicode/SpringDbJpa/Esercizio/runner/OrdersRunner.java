package com.epicode.SpringDbJpa.Esercizio.runner;

import com.epicode.SpringDbJpa.Esercizio.model.*;
import com.epicode.SpringDbJpa.Esercizio.service.OrdersService;
import com.epicode.SpringDbJpa.Esercizio.service.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrdersRunner implements CommandLineRunner {

    @Autowired private OrdersService ordersService;
    @Autowired private ProdottiService prodottiService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("OrdersRunner...");

        //Order o1 = ordersService.createOrder(2, 1);
        //o1.aggiungiProdotti(prodottiService.getPizza("Pizza Margherita"));
        //o1.aggiungiProdotti(prodottiService.getPizza("Salami Pizza"));
        //o1.aggiungiProdotti(prodottiService.getDrink("Water"));
        //o1.aggiungiProdotti(prodottiService.getDrink("Lemonade"));
        //ordersService.salvaOrdine(o1);

        //Order o2 = ordersService.createOrder(3, 2);
        //o2.aggiungiProdotti(prodottiService.getPizza("Pizza Margherita"));
        //o2.aggiungiProdotti(prodottiService.getPizza("Salami Pizza"));
        //o2.aggiungiProdotti(prodottiService.getPizza("Pizza Margherita"));
        //o2.aggiungiProdotti(prodottiService.getDrink("Water"));
        //o2.aggiungiProdotti(prodottiService.getDrink("Water"));
        //o2.aggiungiProdotti(prodottiService.getDrink("Lemonade"));
        //ordersService.salvaOrdine(o2);




    }
}
