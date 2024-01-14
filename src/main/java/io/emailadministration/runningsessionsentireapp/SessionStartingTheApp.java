package io.emailadministration.runningsessionsentireapp;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;

public class SessionStartingTheApp extends RunningSession {

    public SessionStartingTheApp() {
        super();
    }

    public static void logoAndProgressBar() {
        SanityChecks.clearTheArea();
        LoadStartingTheAppEffect.start();
    }
}
