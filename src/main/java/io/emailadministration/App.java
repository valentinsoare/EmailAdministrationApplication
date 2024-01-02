package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.runningsessionsentireapp.*;

public class App extends DBConnection {

    public static void main( String[] args ) {
        SessionStartingTheApp.logoAndProgressBar();
        new SessionWithLoginSignInStartingTheApp().execute();


//        PrintMenu.of(SessionWithMainMenu.getNewMainMenuSession().getMenu());

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
