package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.loading.Loading;
import io.emailadministration.devcomponents.pages.loginsignuppage.LoginSingInPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.printing.PrintError;
import io.emailadministration.printing.PrintMenu;

public class SessionWithLoginSignInStartingTheApp extends RunningSession implements Command {

    public SessionWithLoginSignInStartingTheApp() {
        super();
    }

    public SessionWithLoginSignInStartingTheApp(IMenu menu) {
        super(menu);
    }

    public static SessionWithLoginSignInStartingTheApp getNewInstanceLoginSignUpSession() {
        IMenu iMenu = new LoginSingInPage().generatePage();
        return new SessionWithLoginSignInStartingTheApp(iMenu);
    }

    @Override
    public void execute() {
        IMenu startingTheApp = new LoginSingInPage().generatePage();
        SanityChecks.clearTheArea();

        while (true) {
            PrintMenu.of(startingTheApp);
            catchInputFromUser(false);

            try {
                switch (getInputFromUser()) {
                    case "1" -> {
                        Loading.dots("Loading the sign in page", 5,
                                200,true, "DONE",
                                startingTheApp.menuAttributes().getPosition().getWhiteSpaceLeft()
                        );

                        Thread.sleep(200);
                        SanityChecks.clearTheArea();

                        new SessionWithProvideUserAndPassword().execute();
                    } case "2" -> {
                        Loading.dots("Loading the main menu page", 5,
                                200,true, "DONE",
                                startingTheApp.menuAttributes().getPosition().getWhiteSpaceLeft()
                        );

                        Thread.sleep(200);
                        SanityChecks.clearTheArea();

                        new SessionWithMainMenu().execute();
                    } case "4" -> {
                        SanityChecks.checkIfQuitOrBack(startingTheApp.menuAttributes().getPosition().getWhiteSpaceLeft(),
                                "quit", InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
                        );
                    } default -> {
                        PrintError.toConsole(InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE,
                                startingTheApp.menuAttributes().getPosition().getWhiteSpaceLeft(),
                                1000, false, false
                        );
                    }
                }
            } catch (InterruptedException e) {
                System.out.printf("ERROR - [SessionWithLoginSignInStartingTheApp.execute] - %s", e.getMessage());
            }
        }
    }
}
