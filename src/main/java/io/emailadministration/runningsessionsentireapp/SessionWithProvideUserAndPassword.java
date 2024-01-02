package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.loading.Loading;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.loginsignuppage.signin.ProvideUserAndPasswordPage;
import io.emailadministration.printing.PrintError;
import io.emailadministration.printing.PrintMenu;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class SessionWithProvideUserAndPassword extends RunningSession implements Command  {
    public SessionWithProvideUserAndPassword() {
        super();
    }

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
    public void execute() throws InterruptedException {
        IMenu loginMenu = new ProvideUserAndPasswordPage().generatePage();
        
        while (!"quit".equals(getInputFromUser()) && !"back".equals(getInputFromUser())) {
            PrintMenu.of(loginMenu, false, true,
                    2, true);
            catchInputFromUser(false);

            switch (getInputFromUser()) {
                case "back" -> {
                    Loading.square("back", 20,
                            100, true,"DONE",
                            loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft()
                    );

                    Thread.sleep(500);

                    setInputFromUser(SanityChecks.checkIfQuitOrBack(
                            loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(), "back",
                            InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_BACK
                    ));
                }
                case "quit" -> setInputFromUser(SanityChecks.checkIfQuitOrBack(
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
                        InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
                ));
                default -> PrintError.toConsole(InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE,
                        loginMenu.menuAttributes().getPosition().getWhiteSpaceLeft(),
                        1000, false, false);
            }
        }
    }
}
