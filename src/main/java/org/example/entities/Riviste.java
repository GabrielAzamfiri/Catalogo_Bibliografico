package org.example.entities;


import jakarta.persistence.*;
import org.example.entities.Enum.Periodicita;

@Entity
@DiscriminatorValue("riviste")
public class Riviste extends Catalogo {
    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Riviste() {
    }

    public Riviste(String codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                ", CodiceISBN=" + CodiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
