package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.pages.loginsignuppage.LoginSignUpPage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.printing.PrintMenu;

public class SessionWithLoginSignUp extends RunningSession implements Command {

    public SessionWithLoginSignUp(IMenu menu) {
        super(menu);
    }

    public static SessionWithLoginSignUp getNewInstanceLoginSignUpSession() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        IMenu iMenu = new LoginSignUpPage().generatePage();
        return new SessionWithLoginSignUp(iMenu);
    }

    @Override
    public String execute() {
        PrintMenu.of(getNewInstanceLoginSignUpSession().getMenu());

        String catchValueToReturn = "";

//        switch (super.getInputFromUser()) {
////            case "1" ->;
////            case "2" ->;
////            case "3" ->;
////            case "4" ->;
//            case "5" -> catchValueToReturn = SanityChecks.checkIfQuitOrBack(
//                    super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft(), "quit",
//                    InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
//            );
//            default -> {
//                System.out.printf("%n%s%s%n", " ".repeat(super.getMenu().menuAttributes().getPosition().getWhiteSpaceLeft()),
//                        InputErrors.NON_VALID_OPTION_FROM_THOSE_ABOVE);
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }

        return catchValueToReturn;
    }
}
