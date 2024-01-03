package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.menu.usingmenu.MenuNullObject;
import io.emailadministration.entities.digitalcomponents.User;
import io.emailadministration.entities.digitalcomponents.UserNullObject;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
public abstract class RunningSession {
    private String inputFromUser;
    private final BufferedReader reader;
    private IMenu menu;
    private User currentUser;

    protected RunningSession(String inputFromUser, IMenu menu, User currentUser) {
        this.inputFromUser = inputFromUser;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.menu = menu;
        this.currentUser = currentUser;
    }

    protected RunningSession(IMenu menu) {
        this.inputFromUser = "none";
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.menu = menu;
        this.currentUser = new UserNullObject();
    }

    protected RunningSession() {
        this("none",
                new MenuNullObject(),
                new UserNullObject()
        );
    }

    protected RunningSession(String inputFromUser) {
        this(inputFromUser,
                new MenuNullObject(),
                new UserNullObject()
        );
    }

    public String catchInputFromUser(boolean forConstructor) {
        String valueFromUser = "none";

        try {
            valueFromUser = reader.readLine().trim();

            if (!forConstructor) {
                this.inputFromUser = valueFromUser;
            }

        } catch (IOException e) {
            System.out.printf("ERROR - [catchInputFromUser] - %s", e.getMessage());
        }

        return valueFromUser;
    }
}
