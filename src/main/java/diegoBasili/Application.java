package diegoBasili;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione degli eventi u4-s3-l2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
