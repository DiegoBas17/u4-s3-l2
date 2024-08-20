package diegoBasili.dao;

import diegoBasili.entities.Evento;
import jakarta.persistence.EntityManager;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento save) {

    }
    /*public Evento findById(long eventoId) {

    }*/

    public void findByIdAndDelete(long eventoId) {

    }
}
