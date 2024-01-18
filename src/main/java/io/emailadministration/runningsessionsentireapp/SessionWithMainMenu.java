package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.pages.mainmenupage.MainMenuPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

import java.util.concurrent.TimeUnit;

public class SessionWithMainMenu extends RunningSession implements Command {

    public SessionWithMainMenu(IMenu menu) {
        super(menu);
    }

    public static SessionWithMainMenu getNewMainMenuSession() {
        IMenu iMenu = new MainMenuPage().generatePage();
        return new SessionWithMainMenu(iMenu);
    }

    @Override
    public void execute() throws InterruptedException {
        SanityChecks.clearTheArea();

        String catchValueToReturn = "";

        switch (super.getInputFromUser()) {
            case "14" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
                    super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
            );
            default -> {
                System.out.printf("%n%s%s%n", " ".repeat(super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft() / 2),
                        InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE);
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
