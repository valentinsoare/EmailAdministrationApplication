package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;

public class SessionStartingTheApp extends RunningSession implements Command {

    public SessionStartingTheApp() {
        super();
    }

    public static void logoAndProgressBar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        LoadStartingTheAppEffect.start();
    }

    @Override
    public String execute() {
        logoAndProgressBar();
        return "starting";
    }
}
