package io.emailadministration.devcomponents.auxiliary.checks;

import io.emailadministration.Printing.PrintError;
import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import io.emailadministration.devcomponents.auxiliary.Position.CPositionNullObject;
import io.emailadministration.devcomponents.errorsclasification.ICustomError;
import io.emailadministration.devcomponents.header.Frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.Frame.HFrameWithContentNullObject;
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
                    .map(String::trim)
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

            messageGiven.append("\n");
        }

        return messageGiven.toString();
    }

    public static String checkMessage(String message, boolean isForMenu, boolean classicWay, int emptySpaceOnLeft,
                                      boolean goingBack, boolean quiting, ICustomError error) throws InterruptedException {
        StringBuilder processedMessage = new StringBuilder();

        if (message == null || message.isBlank()) {
            PrintError.toConsole(error, emptySpaceOnLeft, (goingBack || quiting) ? 200 : 1000,
                    goingBack, quiting);
            processedMessage.append("none");

            return processedMessage.toString();
        }

        processedMessage.append(formattingTheMessage(message, isForMenu, classicWay));
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
}
