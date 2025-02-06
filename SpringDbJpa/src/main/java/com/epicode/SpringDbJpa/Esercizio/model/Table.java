package com.epicode.SpringDbJpa.Esercizio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@jakarta.persistence.Table(name = "tavoli")
public class Table {

    @Id
    @GeneratedValue
    private long id;
    private int numTable;
    private int numMaxCoperti;
    private boolean stato;

    public Table(int numTable, int numMaxCoperti, boolean stato) {
        this.numTable = numTable;
        this.numMaxCoperti = numMaxCoperti;
        this.stato = stato;
    }
}
