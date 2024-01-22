package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.loading.Loading;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.loginsignuppage.signin.ProvideUserAndPasswordPage;
import io.emailadministration.printing.PrintError;
import io.emailadministration.printing.PrintMenu;

public class SessionWithProvideUserAndPassword extends RunningSession implements Command  {

    public SessionWithProvideUserAndPassword() {
        super();
    }

    public SessionWithProvideUserAndPassword(IMenu menu) {
        super(menu);
    }

    public static SessionWithProvideUserAndPassword getNewSessionWithProvideUserAndPassword() {
        IMenu iMenu = new ProvideUserAndPasswordPage().generatePage();
        return new SessionWithProvideUserAndPassword(iMenu);
    }

    @Override
    public void execute() throws InterruptedException {
        IMenu loginMenu = new ProvideUserAndPasswordPage().generatePage();
        SanityChecks.clearTheArea();
        String inputFromUser = "";

        while (!"quit".equals(getInputFromUser()) && !"back".equals(getInputFromUser())) {
            PrintMenu.of(loginMenu, false, true,
                         2, true);
            catchInputFromUser(false);

            inputFromUser = getInputFromUser();

            if ("back".equals(inputFromUser)) {
                Loading.square("back", 20,
                        100, true,"Go back!",
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft()
                );

                Thread.sleep(500);

                setInputFromUser(SanityChecks.checkIfQuitOrBack(
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(), "back",
                        InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_BACK
                ));
            } else if ("quit".equals(inputFromUser)) {
                setInputFromUser(SanityChecks.checkIfQuitOrBack(
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
                        InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
                ));
            } else {
                PrintError.toConsole(InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE,
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(),
                        1000, false, false);
            }
        }
    }
}
