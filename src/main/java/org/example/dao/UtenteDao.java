package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Utenti;
import org.example.exceptions.NotFoundException;

public class UtenteDao {
    private final EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }


    public void save(Utenti utente) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();

        System.out.println("L'utente " + utente.getCognome() + " è stato salvato correttamente!");
    }

    public Utenti findById(Integer utenteId) {
        Utenti found = em.find(Utenti.class, utenteId); // Primo parametro è la classe dell'entità, secondo è l'id da cercare
        if (found == null) throw new NotFoundException(utenteId.toString());
        return found;
    }

    public void findByIdAndDelete(Integer utenteId) {
        Utenti found = this.findById(utenteId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("L'utente " + found.getCognome() + " è stato salvato correttamente!");

    }
}
