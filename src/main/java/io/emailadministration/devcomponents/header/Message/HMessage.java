package io.emailadministration.devcomponents.header.Message;

import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Map.entry;

@Getter
@Setter
public class HMessage implements IStylizedMessage {
    private String headerMessage;
    private boolean isMainMessage;
    private MessageStyle style;
    private CPosition position;

    private Map<MessageStyle, String> messagesAfterProcessing;
    private String completeProcessing;

    public HMessage() {}

    public HMessage(String headerMessage, boolean isMainMessage,
                    MessageStyle style, CPosition position) {
        this.style = style;
        this.isMainMessage = isMainMessage;
        this.position = position;
        this.messagesAfterProcessing = new EnumMap<>(MessageStyle.class);


        this.headerMessage = headerMessage;
    }

    public HMessage(HMessage message) {
        this.style = message.getStyle();
        this.isMainMessage = message.isMainMessage();
        this.position = new CPosition(message.getPosition());
        this.messagesAfterProcessing = new EnumMap<>(message.getMessagesAfterProcessing());

        this.headerMessage = new String(message.getHeaderMessage());
    }

    private String createClassicStyleMessage() {
        StringBuilder finalMessage = new StringBuilder();

        Stream<String> streamOfWords = Arrays.stream(headerMessage.trim().toLowerCase().split("\\s+"));

        streamOfWords.map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
            .forEach(e -> finalMessage.append(e).append(" "));

        messagesAfterProcessing.put(MessageStyle.CLASSIC, finalMessage.toString().trim());
        return finalMessage.toString().trim();
    }

    private String createModernStyleMessage() {
        Random rnd = new Random();
        StringBuilder finalMessage = new StringBuilder();

        List<String> letters = new ArrayList<>(Arrays.asList(headerMessage.trim().toLowerCase().split("")));

        if (isMainMessage) {
            for (String letter : letters) {
                if (!letter.isBlank()) {
                    if (rnd.nextInt(2) == 1) {
                        finalMessage.append(letter.toUpperCase());
                    } else {
                        finalMessage.append(letter);
                    }
                } else {
                    finalMessage.append(" ");
                }
            }
        } else {
            finalMessage.append("[ ");
            letters.forEach(word -> finalMessage.append(word).append(" "));
            finalMessage.append(" ]");
        }

        messagesAfterProcessing.put(MessageStyle.MODERN, finalMessage.toString().trim());
        return finalMessage.toString().trim();
    }

    private String createHackerStyleMessage() {
        Map<String, String> l33tLetters = new HashMap<>(
                Map.ofEntries(
                        entry("a", "@"), entry("b", "ß"),
                            entry("e", "3"), entry("f", "ph"), entry("h", "#"),
                            entry("i", "|"), entry("m", "|\\/|"), entry("n", "И"),
                            entry("o", "oh"), entry("p", "⁋"), entry("t", "7")
                )
        );

        StringBuilder finalMessage = new StringBuilder();
        List<String> lettersFromMessage = new ArrayList<>(Arrays.asList(headerMessage.toLowerCase().trim().split("")));

        if (isMainMessage) {
            for (String letter : lettersFromMessage) {
                if (!letter.isBlank()) {
                    finalMessage.append(l33tLetters.getOrDefault(letter, letter));
                } else {
                    finalMessage.append(" ");
                }
            }
        } else {
            finalMessage.append("{ ").append(headerMessage.trim().toLowerCase()).append(" }");
        }

        messagesAfterProcessing.put(MessageStyle.HACKER, finalMessage.toString().trim());
        return finalMessage.toString().trim();
    }

    private String createAsciiStyleMessage(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Arial", Font.PLAIN, 12));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(headerMessage.trim(), 5, 10);

        StringBuilder finalMessage = new StringBuilder();
        finalMessage.append("\n".repeat(position.getWhiteSpaceUp()));

        for (int y = 0; y < height; y++) {

            finalMessage.append(" ".repeat(position.getWhiteSpaceLeft()));

            for (int x = 0; x < width; x++) {
                finalMessage.append(image.getRGB(x, y) == -16777216 ? " " : "#");
            }

            finalMessage.append(System.lineSeparator());
        }

        messagesAfterProcessing.put(MessageStyle.ASCII, finalMessage.toString().trim());
        return finalMessage.toString();
    }

    private void assignProperMessage(boolean withPosition, String styleMessage) {
        if (withPosition) {
            this.completeProcessing =
                    position.addPositionToMessage(styleMessage);
        } else {
            this.completeProcessing = styleMessage;
        }
    }

    @Override
    public Optional<IStylizedMessage> stylizeIt(boolean withPosition, boolean withStyle) {
        switch (style) {
            case MODERN -> assignProperMessage(withPosition, createModernStyleMessage());
            case HACKER -> assignProperMessage(withPosition, createHackerStyleMessage());
            case ASCII  -> this.completeProcessing = createAsciiStyleMessage(56,12);
            default -> assignProperMessage(withPosition, createClassicStyleMessage());
        }

        if (completeProcessing != null) {
            return Optional.of(this);
        }

        assignProperMessage(withPosition, headerMessage);
        return Optional.of(this);
    }

    @Override
    public HMessage getCustomizedMessage() {
        return this;
    }

    @Override
    public String toString() {
        return completeProcessing;
    }
}
