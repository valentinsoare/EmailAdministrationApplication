package io.emailadministration.devcomponents.auxiliary.checks;

import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.header.HeaderNullObject;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.loading.Loading;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessageNullObject;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;
import io.emailadministration.printing.PrintError;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.auxiliary.position.CPositionNullObject;
import io.emailadministration.devcomponents.errorsclasification.ICustomError;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.frame.HFrameWithContentNullObject;
import org.apache.commons.lang3.StringUtils;

import java.text.BreakIterator;
import java.util.*;

public class SanityChecks {
    public static int validatePosition(int numberOfWhiteSpaces, AppliedToArea area) {
        switch (area) {
            case LEFT, RIGHT -> {
                return (numberOfWhiteSpaces < 0) ? 5 : numberOfWhiteSpaces;
            }
            default -> {
                return Math.max(numberOfWhiteSpaces, 0);
            }
        }
    }

    public static Character validateCharToUse(Character charToUse, Character defaultToBeUsed) {
        if (charToUse == null) {
            charToUse = defaultToBeUsed;
        }

        return charToUse;
    }

    public static String formattingTheMessage(String message, boolean isForMenu, boolean classicWay) {
        StringBuilder messageGiven = new StringBuilder();

        if (classicWay) {
            Arrays.stream(message.split( " +"))
                    .forEach(e -> messageGiven.append(e).append(" "));

            return StringUtils.capitalize(messageGiven.toString().trim());
        }

        if (isForMenu) {
            Arrays.stream(message.split(" +"))
                    .map(s -> s.trim().toUpperCase())
                    .forEach(e -> messageGiven.append(e).append(" "));
        } else {
            BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
            iterator.setText(message);

            int start = iterator.first();

            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {

                messageGiven.append(StringUtils.capitalize(message.substring(start,end)))
                        .append(" ");
            }
        }

        return messageGiven.toString();
    }

    public static String checkMessage(String message, boolean isForMenu, boolean classicWay, int emptySpaceOnLeft,
                                      boolean goingBack, boolean quiting, ICustomError error) {

        StringBuilder processedMessage = new StringBuilder();

        try {
            if (message == null || message.isBlank()) {
                PrintError.toConsole(error, emptySpaceOnLeft, (goingBack || quiting) ? 200 : 1000,
                        goingBack, quiting);
                processedMessage.append("none");

                return processedMessage.toString();
            }

            processedMessage.append(formattingTheMessage(message, isForMenu, classicWay));
        } catch (InterruptedException e) {
            System.out.printf("ERROR - [] - %s", e.getMessage());
        }

        return processedMessage.toString();
    }

    public static int checkTimeBetweenCharsSleepValidation(int timeBetweenChars) {
        return Math.max(timeBetweenChars, 75);
    }

    public static CPosition checkPosition(CPosition position) {
        return Objects.requireNonNullElseGet(position, CPositionNullObject::new);
    }

    public static HFrameWithContent checkFrame(HFrameWithContent frame) {
        return Objects.requireNonNullElseGet(frame, HFrameWithContentNullObject::new);
    }

    public static IHeader checkHeader(IHeader header) {
        return Objects.requireNonNullElseGet(header, HeaderNullObject::new);
    }

    public static IAuxMessage checkAuxiliaryMessage(IAuxMessage message, int emptySpaceOnLeft,
                                                    boolean goingBack, boolean quiting, ICustomError error) {

        IAuxMessage iAuxMessage = Objects.requireNonNullElseGet(message, AuxiliaryMessageNullObject::new);

        try {
            if ("AuxiliaryMessageNullObject".equals(iAuxMessage.getTypeOfObject())) {
                PrintError.toConsole(error, emptySpaceOnLeft, (goingBack || quiting) ? 200 : 1000,
                        goingBack, quiting);

                return iAuxMessage;
            }
        } catch (InterruptedException e) {
            System.out.printf("ERROR - [SanityChecks.checkAuxiliaryMessage] - %s", e.getMessage());
        }

        return iAuxMessage;
    }

    public static boolean validateAnyMessageForNullOrBlank(String message, int emptySpaceFromLeft) throws InterruptedException {
        if (message == null || message.isBlank()) {
            PrintError.toConsole(InputErrors.NULL_OR_EMPTY_TEXT, emptySpaceFromLeft, 300,
                    false, true);

            return false;
        }

        return true;
    }

    public static String validateInputEntriesForMenu(String menuEntries, int numberOfEntriesInTheMenu, int emptySpaceFromLeft) throws InterruptedException {
        if (!validateAnyMessageForNullOrBlank(menuEntries, emptySpaceFromLeft)) {
            Loading.dots("Exiting", 6, 100,
                    false, "DONE", emptySpaceFromLeft);
            System.exit(0);
        }

        long count = menuEntries.chars()
                .filter(e -> e == ',')
                .count();

        if (count != numberOfEntriesInTheMenu - 1) {
            PrintError.toConsole(StructuralErrors.NUMBER_OF_OPTIONS_OUT_OF_SYNC_MENU_CREATION, emptySpaceFromLeft,
                    300, false, true);
            System.exit(0);
        }

        return menuEntries.trim();
    }

    public static String checkIfQuitOrBack(int spacesFromLeft, String inputFromUser, ICustomError error) throws InterruptedException {
        String processedValue = "none";

        if (inputFromUser.isBlank()) {
            PrintError.toConsole(error, (spacesFromLeft / 2), 1000,
                    false, false);
            SanityChecks.clearTheArea();
        } else if ("back".equalsIgnoreCase(inputFromUser)) {
            processedValue = "back";
            SanityChecks.clearTheArea();
        } else if ("quit".equalsIgnoreCase(inputFromUser)) {
            Loading.hourGlass("quiting", 10, 150, true,
                    "Bye!", spacesFromLeft);

            System.out.print("\n\n");
            System.exit(0);
        } else {
            processedValue = inputFromUser;
        }

        return processedValue;
    }

    public static void clearTheArea() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
