package com.epicode.SpringDbJpa.Esercizio.service;


import com.epicode.SpringDbJpa.Esercizio.model.Article;
import com.epicode.SpringDbJpa.Esercizio.model.Table;
import com.epicode.SpringDbJpa.Esercizio.model.Topping;
import com.epicode.SpringDbJpa.Esercizio.repository.TableDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired TableDAORepository tableDAO;

    @Autowired @Qualifier("tavolo1") ObjectProvider<Table> tavolo1Provider;
    @Autowired @Qualifier("tavolo2") ObjectProvider<Table> tavolo2Provider;
    @Autowired @Qualifier("tavolo3") ObjectProvider<Table> tavolo3Provider;

    public Table createTable1() {
        return tavolo1Provider.getObject();
    }
    public Table createTable2() {
        return tavolo2Provider.getObject();
    }
    public Table createTable3() {
        return tavolo3Provider.getObject();
    }

    public void salvaTavolo(Table tavolo) {
        tableDAO.save(tavolo);
    }

    public Table getTavolo(int num) {
        return tableDAO.findByNumTable(num);
    }

}
