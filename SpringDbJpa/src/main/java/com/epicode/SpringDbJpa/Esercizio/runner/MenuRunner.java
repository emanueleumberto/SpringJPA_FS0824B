package com.epicode.SpringDbJpa.Esercizio.runner;

import com.epicode.SpringDbJpa.Esercizio.model.Menu;
import com.epicode.SpringDbJpa.Esercizio.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired private MenuService menuService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MenuRunner...");

        //Menu m = menuService.createMenu();
        //menuService.salvaMenu(m);

        //Menu m = menuService.getMenu("Menu Pizzeria Epicode");
        //m.printMenu();
    }
}
