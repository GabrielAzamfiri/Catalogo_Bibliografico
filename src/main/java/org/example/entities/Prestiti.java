package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestiti {
    @Id
    @GeneratedValue
    private UUID prestitoID;

    @ManyToOne
    @JoinColumn(name = "numero_tessera")
    private Utenti utente;

    @ManyToOne
    @JoinColumn(name = "codice_isbn")
    private Catalogo elementoPrestato;

    @Column(name = "data_prestito", nullable = false)
    private LocalDate dataPrestito;

    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva", nullable = false)
    private LocalDate dataRestituzioneEffettiva;

    public Prestiti(Utenti utente, Catalogo elementoPrestato, LocalDate dataPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataPrestito = dataPrestito;
        this.dataRestituzionePrevista = dataPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utenti getUtente() {
        return utente;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Catalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public UUID getPrestitoID() {
        return prestitoID;
    }

    public void setPrestitoID(UUID prestitoID) {
        this.prestitoID = prestitoID;
    }

    public LocalDate getDataPrestito() {
        return dataPrestito;
    }

    public void setDataPrestito(LocalDate dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestiti{" +
                "prestitoID=" + prestitoID +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataPrestito=" + dataPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
