package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.pages.mainmenupage.MainMenuPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.printing.PrintMenu;

import java.util.concurrent.TimeUnit;

public class SessionWithMainMenu extends RunningSession implements Command {

    public SessionWithMainMenu(IMenu menu) {
        super(menu);
    }

    public static SessionWithMainMenu getNewMainMenuSession() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu iMenu = new MainMenuPage().generatePage();
        return new SessionWithMainMenu(iMenu);
    }

    @Override
    public void execute() throws InterruptedException {
        String catchValueToReturn = "";

        switch (super.getInputFromUser()) {
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
            case "14" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
                    super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
            );
            default -> {
                System.out.printf("%n%s%s%n", " ".repeat(super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft()),
                        InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE);
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
