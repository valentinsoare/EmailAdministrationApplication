package io.emailadministration;

import io.emailadministration.DButils.DBConnection;
import io.emailadministration.DButils.EntityManagerScope;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main( String[] args ) {
//        Logger.getLogger("org.hibernate").setLevel(Level.INFO);

        DBConnection instanceOfDB = DBConnection.getInstance();

        EntityManager em = instanceOfDB.generateEntityManager(
                EntityManagerScope.EMAIL_GENERATE
        );

        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            transaction.rollback();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
