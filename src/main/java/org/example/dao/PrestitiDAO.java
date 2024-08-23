package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Prestiti;
import org.example.exceptions.NotFoundException;

public class PrestitiDAO {

    private final EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestiti prestito) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();

        System.out.println("Il prestito " + prestito.getPrestitoID() + " è stato salvato correttamente!");
    }

    public Prestiti findById(Integer prestitoID) {
        Prestiti found = em.find(Prestiti.class, prestitoID); // Primo parametro è la classe dell'entità, secondo è l'id da cercare
        if (found == null) throw new NotFoundException(prestitoID.toString());
        return found;
    }

    public void findByIdAndDelete(Integer prestitoID) {
        Prestiti found = this.findById(prestitoID);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Il prestito " + found.getPrestitoID() + " è stato salvato correttamente!");

    }
}
