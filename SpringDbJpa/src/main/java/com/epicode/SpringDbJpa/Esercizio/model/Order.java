package com.epicode.SpringDbJpa.Esercizio.model;

import com.epicode.SpringDbJpa.Esercizio.Enumeration.Stato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@jakarta.persistence.Table(name = "ordini")
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private static int count = 1;
    private int numeroOrdine;
    @Enumerated(EnumType.STRING)
    private Stato stato;
    private int numCoperti;
    private LocalTime oraAcquisizione;
    @ManyToMany
    @JoinTable(
            name = "ordini_prodotti",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Article> listaProdotti;
    @ManyToOne
    private Table tavolo;
    @Value("${menu.coperto}")
    private double costoCoperto;

    public Order(int numCoperti, Table tavolo) {
        this.numeroOrdine = count++;
        this.stato = Stato.IN_CORSO;
        this.numCoperti = numCoperti;
        this.oraAcquisizione = LocalTime.now();
        this.listaProdotti = new ArrayList<Article>();
        this.tavolo = tavolo;
    }

    public Order() {
        this.numeroOrdine = count++;
        this.stato = Stato.IN_CORSO;
        this.oraAcquisizione = LocalTime.now();
        this.listaProdotti = new ArrayList<Article>();
    }

    public void aggiungiProdotti(Article prodotto) {
        this.listaProdotti.add(prodotto);
    }

    public double totaleOrdine() {
        return this.listaProdotti.stream()
                .mapToDouble(Article::getPrice)
                .sum() + (this.costoCoperto * this.numCoperti);
    }

    public void stampaOrdine() {
        System.out.println("Ordine: " + this.numeroOrdine);
        System.out.println("Stato: " + this.stato);
        System.out.println("Numero coperti: " + this.numCoperti);
        System.out.println("Ora: " + this.oraAcquisizione);
        System.out.println("Tavolo: " + this.getTavolo().getNumTable());
        System.out.println("Lista Prodotti: " + this.listaProdotti.size());
        this.listaProdotti.forEach(ele -> {
            if(ele instanceof Pizza) {
                Pizza p = (Pizza) ele;
                System.out.println(p.getName() + " - Calorie: " + p.getCalories() + " Prezzo: " + p.getPrice());
            } else if(ele instanceof Drink) {
                Drink d = (Drink) ele;
                System.out.println(d.getName() + " - Calorie: " + d.getCalories() + " Prezzo: " + d.getPrice());
            }
        });
        System.out.println("Totale Ordine: " + totaleOrdine());
    }

}
