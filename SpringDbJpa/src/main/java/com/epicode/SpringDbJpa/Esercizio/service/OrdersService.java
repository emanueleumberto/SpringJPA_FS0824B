package com.epicode.SpringDbJpa.Esercizio.service;

import com.epicode.SpringDbJpa.Esercizio.model.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired @Qualifier("menu") ObjectProvider<Menu> menuProvider;
    @Autowired @Qualifier("tavolo1") ObjectProvider<Table> table1Provider;
    @Autowired @Qualifier("tavolo2") ObjectProvider<Table> table2Provider;
    @Autowired @Qualifier("tavolo3") ObjectProvider<Table> table3Provider;
    @Autowired @Qualifier("order") ObjectProvider<Order> orderProvider;


    public Menu createMenu() {
        return menuProvider.getObject();
    }

    public Table createTable1() {
        return table1Provider.getObject();
    }

    public Table createTable2() {
        return table2Provider.getObject();
    }

    public Table createTable3() {
        return table3Provider.getObject();
    }

    public Order createOrder(int numCoperti, Table tavolo) {
        Order o = orderProvider.getObject();
        o.setTavolo(tavolo);
        o.setNumCoperti(numCoperti);
        return o;
    }









}
