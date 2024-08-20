package diegoBasili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data evento")
    private LocalDate data_evento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo_evento;
    @Column(name = "numero massimo partecipanti")
    private long numero_massimo_partecipanti;

    /*COSTRUTTORE VUOTO*/
    public Evento() {
    }

    /*GETTER AND SETTER*/
    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(TipoEvento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public long getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setNumero_massimo_partecipanti(long numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", tipo_evento=" + tipo_evento +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                '}';
    }
}
