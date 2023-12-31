package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;

public class SessionStartingTheApp extends RunningSession {

    public SessionStartingTheApp() {
        super();
    }

    public static void logoAndProgressBar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        LoadStartingTheAppEffect.start();
    }
}
