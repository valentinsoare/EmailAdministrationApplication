package io.emailadministration.devcomponents.loading;

public final class ProgressLinesWithPipe extends LoadingEffect {
    private final Loading loading;

    public ProgressLinesWithPipe(Loading loading) {
        this.loading = loading;
    }

    public static LoadingEffect getNewInstanceOfProgressLinesWithFrontSlash(ProgressLinesWithPipe linesWithFrontSlash) {
        return new ProgressLinesWithPipe(linesWithFrontSlash.loading);
    }

    public void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                      int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("\u001B[?25l");
        System.out.printf("%s%s[ %s] ", "\n".repeat(emptySpaceFromAbove), " ".repeat(emptySpaceFromTheLeft * 3),
                loading.getMessageToBeUsed());

        for (int i = 0; i <= barSize; i++) {
            System.out.printf("%s", "|");
            Thread.sleep(sleepBetweenChars);
        }

        System.out.printf("%s%n", " COMPLETE");
        System.out.print("\u001B[?25h");
        Thread.sleep(500);

        System.out.printf("%s", "\n".repeat(emptySpaceFromBellow));
    }
}
