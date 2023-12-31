package io.emailadministration.printing;

import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

import java.util.List;

public class PrintMenu {

    private PrintMenu() {}

    public static void of(IMenu menu) {
        of(menu, true);
    }

    public static void of(IMenu menu, boolean toCheckNumberOfOptions) {
        List<String> options = menu.menuAttributes().getOptionsForTheMenu();
        StringBuilder sb = new StringBuilder();

        try {
            if (toCheckNumberOfOptions && options.size() <= 1) {
                PrintError.toConsole(StructuralErrors.NO_MENU_OPTION_AVAILABLE,
                        menu.menuAttributes().getPosition().getWhiteSpaceLeft(), 200,
                        false, true);
                System.exit(0);
            }
        } catch (InterruptedException e) {
            System.out.printf("ERROR - [PrintMenu.of] - %s", e.getMessage());
        }

        System.out.printf("\n".repeat(menu.menuAttributes().getPosition().getWhiteSpaceUp()));
        System.out.printf("%s", menu.menuAttributes().getHeader());

        for (int i = 0; i < menu.menuAttributes().getNumberOfEntriesInTheCurrentMenu(); i++) {
            System.out.printf(" %s[ %2d ] %s%n", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                    (i+1), options.get(i));
        }

        System.out.printf("%n%s Current user: %s", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                menu.menuAttributes().getCurrentUser().getUserName());

        System.out.printf("%n%s%s", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                "-".repeat(menu.menuAttributes().getHeader().headerAttributes().getFrameWithMessage().getNumberOfChars()));
        System.out.printf("%n%s%s ", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                menu.menuAttributes().getAuxiliaryMessage().getProcessedAuxiliaryMessage());
    }
}
