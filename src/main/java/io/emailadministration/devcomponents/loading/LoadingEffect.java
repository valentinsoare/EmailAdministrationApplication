package io.emailadministration.devcomponents.loading;

public abstract class LoadingEffect {
    protected LoadingEffect() {}

    public abstract void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                               int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException;
}
