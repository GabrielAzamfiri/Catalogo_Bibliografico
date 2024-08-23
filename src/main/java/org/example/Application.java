package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.CatalogoDAO;
import org.example.dao.PrestitiDAO;
import org.example.dao.UtenteDao;
import org.example.entities.Enum.Periodicita;
import org.example.entities.Libri;
import org.example.entities.Prestiti;
import org.example.entities.Riviste;
import org.example.entities.Utenti;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Catalogo_Bibliografico");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);
        UtenteDao ud = new UtenteDao(em);
        PrestitiDAO pd = new PrestitiDAO(em);


        Libri libro1 = new Libri("asd1asd", "Libro1", 2022, 5000, "Diego Basili", "Giallo");
        Libri libro2 = new Libri("asd2asd", "Libro2", 2023, 300, "Eddy Turpo", "Romanzo");
        Libri libro3 = new Libri("asd3asd", "Libro3", 2021, 2000, "Arianna Loreti", "Thriller");
        Libri libro4 = new Libri("asd4asd", "Libro4", 2024, 1050, "Diego Basili", "Biografia");
        Libri libro5 = new Libri("asd5asd", "Libro5", 2020, 430, "Gabriel Azamfiri", "Fantasy");
//        cd.save(libro1);
//        cd.save(libro2);
//        cd.save(libro3);
//        cd.save(libro4);
//        cd.save(libro5);

        Riviste rivista1 = new Riviste("dsa1dsa", "rivista1", 2022, 5000, Periodicita.MENSILE);
        Riviste rivista2 = new Riviste("dsa2dsa", "rivista2", 2023, 500, Periodicita.SETTIMANALE);
        Riviste rivista3 = new Riviste("dsa3dsa", "rivista3", 2024, 200, Periodicita.SEMESTRALE);
//        cd.save(rivista1);
//        cd.save(rivista2);
//        cd.save(rivista3);

        Utenti utente1 = new Utenti(123, "Diego", "Basili", LocalDate.of(2020, 1, 12));
        Utenti utente2 = new Utenti(321, "Marco", "Ciccio", LocalDate.of(2019, 10, 8));
        Utenti utente3 = new Utenti(213, "Alice", "Meh", LocalDate.of(2018, 8, 3));
//        ud.save(utente1);
//        ud.save(utente2);
//        ud.save(utente3);

        Prestiti prestito1 = new Prestiti(utente1, libro1, LocalDate.of(2024, 8, 20), LocalDate.of(2024, 8, 23));
        Prestiti prestito2 = new Prestiti(utente2, libro2, LocalDate.of(2024, 7, 20), LocalDate.of(2024, 7, 23));
        Prestiti prestito3 = new Prestiti(utente3, libro3, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 5, 23));
//        pd.save(prestito1);
//        pd.save(prestito2);
//        pd.save(prestito3);

        utente1.getPrestiti();
    }
}
