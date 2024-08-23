package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    @Id
    @Column(name = "codice_isbn", nullable = false)
    protected String CodiceISBN;

    @Column(name = "titolo", nullable = false)
    protected String titolo;

    @Column(name = "anno_pubblicazione", nullable = false)
    protected Integer annoPubblicazione;

    @Column(name = "numero_pagine", nullable = false)
    protected Integer numeroPagine;


    protected Catalogo() {
        // OBBLIGATORIO avere un costruttore vuoto nelle entities. Serve a JPA per poter ricreare degli oggetti
        // quando andremo a leggere i record di questa tabella
    }

    public Catalogo(String codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        CodiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceISBN() {
        return CodiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "CodiceISBN=" + CodiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
