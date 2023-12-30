package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.runningsessionsentireapp.SessionWithMainMenu;

public class App extends DBConnection {

    public static void main( String[] args ) {
        SessionWithMainMenu sessionWithMainMenu = new SessionWithMainMenu();

        sessionWithMainMenu.startingTheAppWithLogoAndLoadingBar();
        sessionWithMainMenu.loadingTheLogInSignUpPage();
        sessionWithMainMenu.mainMenuPageLoader();


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
