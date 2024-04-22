package io.emailadministration.devcomponents.loading;

public final class ProgressLinesDirection extends LoadingEffect {

    private final Loading loading;

    public ProgressLinesDirection(Loading loading) {
        this.loading = loading;
    }

    public static LoadingEffect getNewInstanceOfProgressLinesDirection(ProgressLinesDirection lines) {
        return new ProgressLinesDirection(lines.loading);
    }

    @Override
    public void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                      int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException {

        StringBuilder effect = new StringBuilder().append(String.valueOf(loading.getCharNotPassed()).repeat(Math.max(0, barSize)));

        System.out.print("\u001B[?25l");
        System.out.printf("%s%s [+] %s [+]%s", "\n".repeat(emptySpaceFromAbove), " ".repeat( emptySpaceFromTheLeft * 2),
                loading.getMessageToBeUsed().trim(), "\n".repeat(emptySpaceFromBellow));

        String toBePrinted = "";
        int status, move, numberOfPasses = 0, j = 1, end = 100;

        for (; j <= barSize; j++) {
            status = (100 * (j - 1)) / (barSize - 1);
            move = (barSize * status) / end;

            if (numberOfPasses == 0) {
                toBePrinted = String.format(" [%s%s] %s%%", effect.substring(0, move)
                                .replace(loading.getCharNotPassed(), loading.getCharToUse()) + ">",
                        effect.substring(move, effect.length()), status / 2);
            } else {
                toBePrinted = String.format(" [%s%s] %s%%", effect.substring(move, effect.length()), "<" + effect.substring(0, move)
                                .replace(loading.getCharNotPassed(), loading.getCharToUse()), (status / 2 + 50));
                if (status == end) {
                    System.out.printf("%s%s COMPLETED!%n%n", " ".repeat(emptySpaceFromTheLeft), toBePrinted);
                    System.out.print("\u001B[?25h");
                    break;
                }
            }

            System.out.printf("%s%s\r", " ".repeat(emptySpaceFromTheLeft), toBePrinted);

            if (j == barSize) {
                j = 1;
                numberOfPasses++;
            }

            Thread.sleep(sleepBetweenChars);
        }
    }
}