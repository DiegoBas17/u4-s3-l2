package diegoBasili;

import diegoBasili.dao.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione degli eventi u4-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);

        /*Evento cenaDiRitrovo = new Evento("cena", LocalDate.of(2024, 8, 29), "ritrovo con i compagni di classe", TipoEvento.PRIVATO, 20);*/
        /*sd.save(cenaDiRitrovo);*/


        em.close();
        emf.close();
        System.out.println("ciao");
    }

}
