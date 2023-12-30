package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.loginpage.LoginOrSignUp;
import io.emailadministration.devcomponents.mainmenupage.MainMenuPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;
import io.emailadministration.entities.businesscomponents.digitalcomponents.User;
import io.emailadministration.printing.PrintMenu;

import java.util.concurrent.TimeUnit;

public class SessionWithMainMenu extends RunningSession {
    private CPosition position;
    private User currentUser;

    public SessionWithMainMenu() {
        super("none");
        this.position = new CPosition(2, 1, 12, 0);
        this.currentUser = new User();
    }

    public SessionWithMainMenu(CPosition position, User currentUser) {
        super("none");

        this.position = position;
        this.currentUser = currentUser;
    }

    public SessionWithMainMenu(String inputFromUser, CPosition position, User currentUser) {
       super(inputFromUser);

       this.position = position;
       this.currentUser = currentUser;
    }

    public void startingTheAppWithLogoAndLoadingBar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        LoadStartingTheAppEffect.start();
    }

    public void loadingTheLogInSignUpPage() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu loginSignup = new LoginOrSignUp().generateLoginOrSignUpPage();
        PrintMenu.of(loginSignup);
    }

    public void mainMenuPageLoader() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu mainMenu = new MainMenuPage().generateMainMenuPage();
        PrintMenu.of(mainMenu);
    }

//    public String actOnInputFromMainMenu() throws InterruptedException {
//        String catchValueToReturn = "";
//
//        switch (super.getInputFromUser()) {
//            case "1" ->;
//            case "2" ->;
//            case "3" ->;
//            case "4" ->;
//            case "5" ->;
//            case "6" ->;
//            case "7" ->;
//            case "8" ->;
//            case "9" ->;
//            case "10" ->;
//            case "11" ->;
//            case "12" ->;
//            case "13" ->;
//            case "14" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
//                    position.getWhiteSpaceLeft(), "quit",
//                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
//            );
//            default -> {
//                System.out.printf("%n%s%s%n", " ".repeat(position.getWhiteSpaceLeft()),
//                        InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE);
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }
//    }
}
