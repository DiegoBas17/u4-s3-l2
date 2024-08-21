package diegoBasili.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona_id;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento_id;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona_id=" + persona_id.getId() +
                ", evento_id=" + evento_id.getId() +
                ", stato=" + stato +
                '}';
    }
}
