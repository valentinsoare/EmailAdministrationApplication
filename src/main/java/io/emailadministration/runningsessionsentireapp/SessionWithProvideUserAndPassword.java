package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.loginsignuppage.signup.ProvideUserAndPasswordPage;

import java.util.concurrent.TimeUnit;

public class SessionWithProvideUserAndPassword extends RunningSession implements Command  {

    public SessionWithProvideUserAndPassword(IMenu menu) {
        super(menu);
    }

    public static SessionWithProvideUserAndPassword getNewSessionWithProvideUserAndPassword() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu iMenu = new ProvideUserAndPasswordPage().generatePage();
        return new SessionWithProvideUserAndPassword(iMenu);
    }

    @Override
    public String execute() throws InterruptedException {
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
}