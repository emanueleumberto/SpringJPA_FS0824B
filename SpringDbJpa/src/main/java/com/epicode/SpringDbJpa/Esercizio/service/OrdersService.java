package com.epicode.SpringDbJpa.Esercizio.service;

import com.epicode.SpringDbJpa.Esercizio.model.*;
import com.epicode.SpringDbJpa.Esercizio.repository.OrderDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired OrderDAORepository orderDAO;
    @Autowired @Qualifier("order") ObjectProvider<Order> orderProvider;
    @Autowired TableService tableService;

    public Order createOrder(int numCoperti, int numTavolo) {
        Order o = orderProvider.getObject();
        o.setTavolo(tableService.getTavolo(numTavolo));
        o.setNumCoperti(numCoperti);
        return o;
    }

    public void salvaOrdine(Order ordine) {
        orderDAO.save(ordine);
    }

}
