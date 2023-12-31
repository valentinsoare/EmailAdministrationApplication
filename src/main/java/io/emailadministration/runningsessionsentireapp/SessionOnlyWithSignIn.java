package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.GenericPage;
import io.emailadministration.devcomponents.pages.loginsignuppage.signin.SignInPage;
import io.emailadministration.printing.PrintMenu;

import java.util.concurrent.TimeUnit;

public class SessionOnlyWithSignIn extends RunningSession implements Command {
    public SessionOnlyWithSignIn() {
        super();
    }

    public SessionOnlyWithSignIn(IMenu menu) {
        super(menu);
    }

    public static SessionOnlyWithSignIn getNewInstanceOfSignInSession() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu iMenu = new SignInPage().generatePage();
        return new SessionOnlyWithSignIn(iMenu);
    }


    @Override
    public String execute() throws InterruptedException {
        PrintMenu.of(getNewInstanceOfSignInSession().getMenu());

        String catchValueToReturn = "";

        switch (super.getInputFromUser()) {
//            case "1" ->;
//            case "2" ->;
            case "3" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
                    super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft(), "back",
                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_BACK
            );
            case "4" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
                    super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
            );
            default -> {
                System.out.printf("%n%s%s%n", " ".repeat(super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft()),
                        InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE);
                TimeUnit.SECONDS.sleep(1);
            }
        }

        return catchValueToReturn;
    }

    @Override
    public String toString() {
        PrintMenu.of(super.getMenu());
        return "";
    }
}
