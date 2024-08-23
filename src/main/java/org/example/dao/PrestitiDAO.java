package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.entities.Prestiti;
import org.example.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;

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

    public List<Prestiti> findElementoByTessera(Integer tessera) {

        TypedQuery<Prestiti> query = em.createQuery("SELECT a FROM Prestiti a WHERE a.utente.numeroTessera = :tessera AND a.dataRestituzioneEffettiva IS NULL", Prestiti.class);
        query.setParameter("tessera", tessera);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono Elementi collegati a questa tessera!");

        }
        return query.getResultList();
    }


    public List<Prestiti> findPrestitiScaduti() {
        LocalDate now = LocalDate.now();
        TypedQuery<Prestiti> query = em.createQuery("SELECT a FROM Prestiti a WHERE a.dataRestituzioneEffettiva IS NULL AND a.dataRestituzionePrevista < :now", Prestiti.class);
        query.setParameter("now", now);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono prestiti scaduti!");

        }
        return query.getResultList();
    }
}
