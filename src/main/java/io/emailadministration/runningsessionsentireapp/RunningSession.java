package io.emailadministration.runningsessionsentireapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class RunningSession {
    private String inputFromUser;
    private final BufferedReader reader;

    protected RunningSession() {
        this.inputFromUser = "none";
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    protected RunningSession(String inputFromUser) {
        this.inputFromUser = inputFromUser;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
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

    public String getInputFromUser() {
        return inputFromUser;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
