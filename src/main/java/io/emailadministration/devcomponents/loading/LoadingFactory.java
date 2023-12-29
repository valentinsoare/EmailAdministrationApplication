package io.emailadministration.devcomponents.loading;

public class LoadingFactory {

    private LoadingFactory() {}

    public static LoadingEffect getLoadEffect(String typeOfLoadEffect, String message, int spacesFromTheLeft)
            throws InterruptedException {
        return switch (typeOfLoadEffect.toLowerCase()) {
            case "progresslines" -> new ProgressBar(new Loading('|', message,
                    ' ', spacesFromTheLeft));
            case "linesdirection" -> new ProgressLinesDirection(new Loading('=', message,
                    ' ', spacesFromTheLeft));
            case "lineswithpipe" -> new ProgressLinesWithPipe(new Loading('|', message,
                    ' ', spacesFromTheLeft));
            default -> new ProgressBar(new Loading('#', message,
                    ' ', spacesFromTheLeft));
        };
    }
}
