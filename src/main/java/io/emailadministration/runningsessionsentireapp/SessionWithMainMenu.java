package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.logging.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.pages.mainmenupage.MainMenuIPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.printing.PrintError;
import io.emailadministration.printing.PrintMenu;

public class SessionWithMainMenu extends RunningSession implements Command {

    public SessionWithMainMenu() {}

    public SessionWithMainMenu(IMenu menu) {
        super(menu);
    }

    public static SessionWithMainMenu getNewMainMenuSession() {
        IMenu iMenu = new MainMenuIPage().generatePage();
        return new SessionWithMainMenu(iMenu);
    }

    @Override
    public void execute() throws InterruptedException {
        IMenu mainMenuPage = new MainMenuIPage().generatePage();
        SanityChecks.clearTheArea();

        String catchValueToReturn = "none";

        do {
            try {
                PrintMenu.of(mainMenuPage);
                catchInputFromUser(false);

                switch (super.getInputFromUser()) {
                    case "15" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
                            mainMenuPage.menuAttributes().getPosition().getWhiteSpaceLeft(),
                            "quit",InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
                    );
                    default -> {
                        PrintError.toConsole(InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE,
                                mainMenuPage.menuAttributes().getPosition().getWhiteSpaceLeft(),
                                1000, false, false
                        );
                    }
                }
            } catch (InterruptedException e) {
                System.out.printf("ERROR - [SessionWithMainMenu.execute] - %s", e.getMessage());
            }
        } while (true);
    }
}
