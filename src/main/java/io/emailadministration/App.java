package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.dbutils.EntityManagerScope;
import io.emailadministration.runningsessionsentireapp.SessionStartingTheApp;
import io.emailadministration.runningsessionsentireapp.SessionWithLoginSignInStartingTheApp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends DBConnection {

    public static void main( String[] args ) {
        SessionStartingTheApp.logoAndProgressBar();
        new SessionWithLoginSignInStartingTheApp().execute();

        //-----------------------------------------------------------


        //------------------------------------------------------------
//        Logger.getLogger("org.hibernate").setLevel(Level.INFO);
//
//        DBConnection instanceOfDB = getInstance();
//
//        EntityManager em = instanceOfDB.generateEntityManager(
//                EntityManagerScope.EMAIL_GENERATE
//        );
//
//        EntityTransaction transaction = null;
//
//        em.setFlushMode(FlushModeType.COMMIT);
//
//        try (em) {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
    }
}
