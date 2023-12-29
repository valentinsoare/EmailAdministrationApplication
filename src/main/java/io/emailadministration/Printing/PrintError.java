package io.emailadministration.Printing;

import io.emailadministration.devcomponents.errorsclasification.ICustomError;
import io.emailadministration.devcomponents.loading.Loading;
import org.apache.commons.lang3.StringUtils;

public class PrintError {

    private PrintError() {}

    public static String toConsole(ICustomError error, int emptySpaceOnTheLeft,
                                   int timeToSleep, boolean goingBack, boolean quiting) throws InterruptedException {
        StringBuilder messageToReturn = new StringBuilder();
        String message = error.getContent();

        System.out.printf("%n%s\033[31m%s\033[0m", " ".repeat(emptySpaceOnTheLeft), "-".repeat(message.length()));
        System.out.printf("%n%s\033[31m%s\033[0m"," ".repeat(emptySpaceOnTheLeft), StringUtils.capitalize(message));
        System.out.printf("%n%s\033[31m%s\033[0m%n%n", " ".repeat(emptySpaceOnTheLeft), "-".repeat(message.length()));

        Thread.sleep(timeToSleep);

        if (goingBack) {
            messageToReturn.append("back");

            Loading.dots("going back", 6, 100,
                    true, "DONE", emptySpaceOnTheLeft);
        } else if (quiting) {
            messageToReturn.append("quiting");

            Loading.dots("exiting", 6, 100,
                    true, "DONE", emptySpaceOnTheLeft);
        }

        return messageToReturn.toString();
    }
}
