package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.devcomponents.loginpage.LoginOrSignUp;
import io.emailadministration.devcomponents.mainmenupage.MainMenuPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;
import io.emailadministration.printing.PrintMenu;

public class App extends DBConnection {
    public static void startingTheAppWithLogoAndLoadingBar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        LoadStartingTheAppEffect.start();
    }

    public static void loadingTheLogInSignUpPage() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu loginSignup = new LoginOrSignUp().generateLoginOrSignUpPage();
        PrintMenu.of(loginSignup);
    }

    public static void mainMenuPageLoader() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu mainMenu = new MainMenuPage().generateMainMenuPage();
        PrintMenu.of(mainMenu);
    }

    public static void main( String[] args ) {
        startingTheAppWithLogoAndLoadingBar();
        loadingTheLogInSignUpPage();
        mainMenuPageLoader();


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
