package com.epicode.SpringDbJpa.Esercizio.service;

import com.epicode.SpringDbJpa.Esercizio.model.Article;
import com.epicode.SpringDbJpa.Esercizio.model.Menu;
import com.epicode.SpringDbJpa.Esercizio.repository.MenuDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired MenuDAORepository menuDao;
    @Autowired ProdottiService prodottiService;

    @Autowired @Qualifier("menu") ObjectProvider<Menu> menuProvider;

    public Menu createMenu() {
        Menu menu = menuProvider.getObject();
        menu.setNome("Menu Pizzeria Epicode");
        menu.getMenuList().add(prodottiService.getPizza("Pizza Margherita"));
        menu.getMenuList().add(prodottiService.getPizza("Salami Pizza"));
        menu.getMenuList().add(prodottiService.getTopping("Tomato"));
        menu.getMenuList().add(prodottiService.getTopping("Cheese"));
        menu.getMenuList().add(prodottiService.getTopping("Salami"));
        menu.getMenuList().add(prodottiService.getDrink("Water"));
        menu.getMenuList().add(prodottiService.getDrink("Lemonade"));
        return menu;
    }

    public void salvaMenu(Menu menu) {
        menuDao.save(menu);
    }

    public Menu getMenu(String nome) {
        return menuDao.findByNome(nome);
    }


}
