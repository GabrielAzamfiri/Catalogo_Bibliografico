package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entities.Catalogo;
import org.example.exceptions.NotFoundException;

public class CatalogoDAO {

    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Catalogo book) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();

        System.out.println("Il Book " + book.getTitolo() + " è stato salvato correttamente!");
    }

    public Catalogo findById(String bookId) {
        Catalogo found = em.find(Catalogo.class, bookId); // Primo parametro è la classe dell'entità, secondo è l'id da cercare
        if (found == null) throw new NotFoundException(bookId);
        return found;
    }

    public void findByIdAndDelete(String bookId) {
        Catalogo found = this.findById(bookId);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(found);

        transaction.commit();

        System.out.println("Il Book " + found.getTitolo() + " è stato eliminato correttamente!");
    }

}
