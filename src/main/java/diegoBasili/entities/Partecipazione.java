package diegoBasili.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;

    private Persona persona_id;
    private Evento evento_id;
    private Stato stato;

    public Partecipazione() {
    }
}
