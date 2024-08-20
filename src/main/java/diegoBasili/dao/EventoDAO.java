package diegoBasili.dao;

import diegoBasili.entities.Evento;
import diegoBasili.exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
// 1. Chiediamo all'entity manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo lo studente al Persistence Context (a questo step lo studente non è ancora salvato a db)
        em.persist(evento);

        // 4. Concludiamo la transazione (qua lo studente verrà effettivamente salvato)
        transaction.commit();
    }

    public Evento findById(long eventoId) {
        Evento found = em.find(Evento.class, eventoId);
        if (found == null) throw new NotFoundEx(eventoId);
        return found;
    }

    public void findByIdAndDelete(long eventoId) {
        Evento found = this.findById(eventoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("l'evento è stato rimosso!");
    }
}
