package diegoBasili;

import diegoBasili.dao.EventoDAO;
import diegoBasili.dao.LocationDAO;
import diegoBasili.dao.PartecipazioneDAO;
import diegoBasili.dao.PersonaDAO;
import diegoBasili.entities.*;
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
        //sd.save(cenaDiRitrovo);
        Evento eventoFromDb = sd.findById("8aab5955-a387-4b34-883b-37d632168959");

        PersonaDAO pd = new PersonaDAO(em);
        Persona gabriel = new Persona("gabriel", "azafiiri", "gabrielclown", LocalDate.of(1997, 10, 29), Sesso.TANTO);
        //pd.save(gabriel);
        Persona gabrielFromDb = pd.findById("d9914932-1a3a-4671-ad9e-5bc9bb4568b0");

        LocationDAO ld = new LocationDAO(em);
        Location roma = new Location("roma", "roma");
        //ld.save(roma);

        PartecipazioneDAO parted = new PartecipazioneDAO(em);
        Partecipazione partecipazione = new Partecipazione(gabrielFromDb, eventoFromDb, Stato.CONFERMATO);
        //parted.save(partecipazione);

        em.close();
        emf.close();
        System.out.println("ciao");
    }

}
