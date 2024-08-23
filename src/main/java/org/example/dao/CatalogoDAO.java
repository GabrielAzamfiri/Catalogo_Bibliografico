package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.entities.Catalogo;
import org.example.entities.Libri;
import org.example.exceptions.NotFoundException;

import java.util.List;

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

    public List<Catalogo> findByAnnoDiPubblicazione(Integer anno) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT a FROM Catalogo a WHERE a.annoPubblicazione = :anno ", Catalogo.class);
        query.setParameter("anno", anno);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono pubblicazioni in questo anno!");
        }
        return query.getResultList();
    }

    public List<Libri> findByAutore(String autore) {
        TypedQuery<Libri> query = em.createQuery("SELECT a FROM Libri a WHERE a.autore = :autore ", Libri.class);
        query.setParameter("autore", autore);
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono pubblicazioni per questo autore!");
        }
        return query.getResultList();
    }

    public List<Catalogo> findBytitolo(String titolo) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT a FROM Catalogo a WHERE a.titolo LIKE :titolo ", Catalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        if (query.getResultList().isEmpty()) {
            System.out.println("Non ci sono pubblicazioni con questo titolo!");
        }
        return query.getResultList();
    }
}
