package diegoBasili.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private Sesso sesso;

    /*COSTRUTTORE VUOTO*/
    public Persona() {
    }

}
