package diegoBasili;

import diegoBasili.dao.EventoDAO;
import diegoBasili.entities.Evento;
import diegoBasili.entities.TipoEvento;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione degli eventi u4-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);

        // Crea un nuovo evento e lo salva
        Evento cenaDiRitrovo = new Evento("cena", LocalDate.of(2024, 8, 29), "ritrovo con i compagni di classe", TipoEvento.PRIVATO, 20);
        sd.save(cenaDiRitrovo);

        // Ottieni l'ID dell'evento appena creato
        UUID eventoId = cenaDiRitrovo.getId();

        try {
            // Cerca l'evento usando il suo ID
            Evento eventoFromDb = sd.findById(eventoId);
            System.out.println(eventoFromDb);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }

        try {
            // Elimina l'evento usando il suo ID
            sd.findByIdAndDelete(eventoId);
        } catch (NotFoundEx ex) {
            System.out.println(ex.getMessage());
        }

        em.close();
        emf.close();
        System.out.println("ciao");
    }

}
