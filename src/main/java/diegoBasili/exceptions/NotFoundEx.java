package diegoBasili.exceptions;

public class NotFoundEx extends RuntimeException {
    public NotFoundEx(long eventoId) {
        super("l'evento con id " + eventoId + " non è stato trovato");
    }

}
