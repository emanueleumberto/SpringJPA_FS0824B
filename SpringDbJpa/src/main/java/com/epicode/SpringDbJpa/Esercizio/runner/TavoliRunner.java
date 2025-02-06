package com.epicode.SpringDbJpa.Esercizio.runner;

import com.epicode.SpringDbJpa.Esercizio.model.Table;
import com.epicode.SpringDbJpa.Esercizio.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TavoliRunner implements CommandLineRunner {

    @Autowired
    private TableService tavoliService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TavoliRunner...");

        //Table t1 = tavoliService.createTable1();
        //Table t2 = tavoliService.createTable2();
        //Table t3 = tavoliService.createTable3();
        //tavoliService.salvaTavolo(t3);

    }
}
