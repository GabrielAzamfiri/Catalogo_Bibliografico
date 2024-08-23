package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utenti")
public class Utenti {
    @Id
    @Column(name = "numero_tessera", nullable = false)
    private Integer numeroTessera;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate dataDiNascita;

    @OneToMany(mappedBy = "utente")
    private Set<Prestiti> prestiti;

    public Utenti() {
    }

    public Utenti(Integer numeroTessera, String nome, String cognome, LocalDate dataDiNascita) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;

    }

    public Integer getNumeroTessera() {
        return numeroTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Prestiti> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(Set<Prestiti> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", prestiti=" + prestiti +
                '}';
    }
}
