package io.emailadministration.devcomponents.loading;

public final class ProgressBar extends LoadingEffect {
    private final Loading loading;

    public ProgressBar(Loading loading) {
        super();

        this.loading = loading;
    }

    public static LoadingEffect getNewInstanceOfProgressBar(ProgressBar bar) {
        return new ProgressBar(bar.loading);
    }

    @Override
    public void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                      int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException {
        String toBePrinted = "";
        int status,move;

        StringBuilder bar = new StringBuilder();
        bar.append(String.valueOf(loading.getCharNotPassed()).repeat(Math.max(0, barSize)));

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("\u001B[?25l"); // hide the cursor
        System.out.printf("%s%s%s%s", "\n".repeat(emptySpaceFromAbove), " ".repeat(emptySpaceFromTheLeft * 3),
                loading.getMessageToBeUsed(), "\n".repeat(emptySpaceFromBellow));

        for (int i = 1; i <= barSize; i++) {
            status = (100 * (i - 1)) / (barSize - 1);
            move = (barSize * status) / 100;

            toBePrinted = String.format("%s", ("[" + bar.substring(0, move).replace(loading.getCharNotPassed(),
                    loading.getCharToUse()) + bar.substring(move, bar.length()) + "] " + status + "%"));
            System.out.printf("\r%s%s", " ".repeat(emptySpaceFromTheLeft), toBePrinted);

            Thread.sleep(sleepBetweenChars);
        }

        System.out.printf("%s%n", " COMPLETE");
        System.out.print("\u001B[?25h"); //show the cursor
        Thread.sleep(500);
    }
}
