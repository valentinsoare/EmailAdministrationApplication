package io.emailadministration.printing;

import io.emailadministration.devcomponents.logging.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintMenu {

    private PrintMenu() {}

    public static void of(IMenu menu) {
        of(menu, true, false, 0, false);
    }

    public static void of(IMenu menu, boolean toCheckNumberOfOptions, boolean printAdditional,
                          int howManyWithAddition, boolean onlyAdditionalMessage) {
        String additionalPrinting;
        List<String> options = menu.menuAttributes().getOptionsForTheMenu();

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

        if (onlyAdditionalMessage) {
            List<String> elements = new ArrayList<>(
                    Arrays.asList(menu.menuAttributes().getAdditionalMessageAsANote().split(" "))
            );

            int space = menu.menuAttributes().getPosition().getWhiteSpaceLeft();

            System.out.printf(" %s%s%n", " ".repeat(space),
                    String.join(" ", elements.subList(0, 9)) + "\n" + " ".repeat(space + 1) +
                    String.join(" ", elements.subList(9, elements.size()))
            );
        } else {
            for (int i = 0; i < menu.menuAttributes().getNumberOfEntriesInTheCurrentMenu(); i++) {
                if (printAdditional && i < howManyWithAddition) {
                    additionalPrinting = (String) menu.menuAttributes().getStoringInputValuesFromUser().get(options.get(i));

                    System.out.printf(" %s[ %2d ] %s (provided: %s)%n", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                            (i + 1), options.get(i), (additionalPrinting == null) ? "none" : additionalPrinting);
                } else {
                    System.out.printf(" %s[ %2d ] %s%n", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                            (i + 1), options.get(i));
                }
            }
        }

        System.out.printf("%n%s Current user: %s", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                menu.menuAttributes().getCurrentUser().getUserName());
        System.out.printf("%n%s%s", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                "-".repeat(menu.menuAttributes().getHeader().headerAttributes().getFrameWithMessage().getNumberOfChars()));
        System.out.printf("%n%s%s", " ".repeat(menu.menuAttributes().getPosition().getWhiteSpaceLeft()),
                menu.menuAttributes().getAuxiliaryMessage().getProcessedAuxiliaryMessage());
    }
}
