package io.emailadministration.runningsessionsentireapp;

public interface Command {
    String execute() throws InterruptedException;
}
