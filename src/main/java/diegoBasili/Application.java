package diegoBasili;

import diegoBasili.dao.EventoDAO;
import diegoBasili.entities.Evento;
import diegoBasili.entities.TipoEvento;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione degli eventi u4-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        Evento cenaDiRitrovo = new Evento("cena", LocalDate.of(2024, 8, 29), "ritrovo con i compagni di classe", TipoEvento.PRIVATO, 20);
        sd.save(cenaDiRitrovo);

        try {
            Evento aldoFromDb = sd.findById(1);
            System.out.println(aldoFromDb);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }

        try {
            sd.findByIdAndDelete(1);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }
        em.close();
        emf.close();
    }
}
