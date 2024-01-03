package io.emailadministration.devcomponents.header.frame;

import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.header.message.HMessage;
import io.emailadministration.devcomponents.header.message.HMessageNullObject;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HFrameWithContent implements IFrame {
    private Character upAndDownFrameChar;
    private Character leftRightFrameChar;
    private int numberOfChars;

    private IStylizedMessage mainMessage;

    private boolean withSecondaryMessage;
    private IStylizedMessage secondaryMessage;

    private CPosition position;

    private String finalMessageWithFrame;

    public HFrameWithContent() {
    }

    public HFrameWithContent(Character upAndDownFrameChar, int numberOfChars, CPosition position) {
        this.upAndDownFrameChar = SanityChecks.validateCharToUse(upAndDownFrameChar, '-');
        this.numberOfChars = (numberOfChars < 0) ? 60 : numberOfChars;
        setPosition(position);
    }

    public HFrameWithContent(Character upAndDownFrameChar, int numberOfChars, CPosition position, IStylizedMessage mainMessage) {
        this(upAndDownFrameChar, numberOfChars, position);

        setHFrameWithMainMessage(mainMessage, false);
    }

    public HFrameWithContent(Character upAndDownFrameChar, Character leftRightFrameChar, int numberOfChars,
                             CPosition position, IStylizedMessage mainMessage,
                             boolean withSecondaryMessage, IStylizedMessage secondaryMessage) {
        this(upAndDownFrameChar, numberOfChars, position, mainMessage);

        this.leftRightFrameChar = SanityChecks.validateCharToUse(leftRightFrameChar, '|');

        this.withSecondaryMessage = withSecondaryMessage;
        setHFrameWithMainMessage(secondaryMessage, true);
    }

    public HFrameWithContent(HFrameWithContent hFrameWithContent) {
        this.upAndDownFrameChar = hFrameWithContent.getUpAndDownFrameChar();
        this.leftRightFrameChar = hFrameWithContent.getLeftRightFrameChar();
        this.numberOfChars = hFrameWithContent.getNumberOfChars();
        this.mainMessage = new HMessage((HMessage) hFrameWithContent.getMainMessage());
        this.withSecondaryMessage = hFrameWithContent.isWithSecondaryMessage();
        this.secondaryMessage = new HMessage((HMessage) hFrameWithContent.getSecondaryMessage());
        this.position = new CPosition(hFrameWithContent.getPosition());
        this.finalMessageWithFrame = hFrameWithContent.getFinalMessageWithFrame();
    }

    public static HFrameWithContent getNewInstance(HFrameWithContent hFrameWithContent) {
        return new HFrameWithContent(hFrameWithContent);
    }

    public void setHFrameWithMainMessage(IStylizedMessage msg, boolean isSecondary) {
        String outputAfterChecking = SanityChecks.checkMessage(
                msg.stylizedMessageAttributes().getCompleteProcessing(),
                false, true, position.getWhiteSpaceLeft(),
                false, true, StructuralErrors.NO_VALID_MESSAGE_HEADER
        );

        if (!isSecondary) {
            if ("none".equals(outputAfterChecking)) {
                this.mainMessage = new HMessageNullObject();
            } else {
                this.mainMessage = msg;
            }

            return;
        }

        if ("none".equals(outputAfterChecking)) {
            this.secondaryMessage = new HMessageNullObject();
        } else {
            this.secondaryMessage = msg;
        }
    }

    public void setPosition(CPosition position) {
        CPosition headerCPosition = SanityChecks.checkPosition(position);

        if ("CPositionNullObject".equals(headerCPosition.getTypeOfObject())) {
            this.position = new CPosition(2, 2, 2, 2);
        } else {
            this.position = headerCPosition;
        }
    }

    public String generateFrameWithMessageAndCharsOnUpDownBorders() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n".repeat(position.getWhiteSpaceUp()))
                .append(" ".repeat(position.getWhiteSpaceLeft()))
                .append(upAndDownFrameChar.toString().repeat(numberOfChars))
                .append(" ".repeat(position.getWhiteSpaceLeft()))
                .append(mainMessage)
                .append(" ".repeat(position.getWhiteSpaceLeft()))
                .append(upAndDownFrameChar.toString().repeat(numberOfChars))
                .append("\n".repeat(position.getWhiteSpaceDown()));

        if (withSecondaryMessage) {
            int secondaryLength = secondaryMessage.stylizedMessageAttributes().getCompleteProcessing().length();

            int whiteSpacesForSecondaryMessageFromTheLeft = ((numberOfChars / 2) - (secondaryLength / 2));

            sb.append(" ".repeat(whiteSpacesForSecondaryMessageFromTheLeft))
                    .append(secondaryMessage);
        }

        this.finalMessageWithFrame = sb.toString();
        return finalMessageWithFrame;
    }

    public String generateFrameWithMessageAndCharsAllAround() {
        StringBuilder sb = new StringBuilder();
        HMessage mainMessageFinalWithPosition = mainMessage.stylizedMessageAttributes();

        int numberOfRowsBetweenUpDownBorders = (mainMessageFinalWithPosition.getPosition().getWhiteSpaceUp() +
                mainMessageFinalWithPosition.getPosition().getWhiteSpaceDown());

        if (numberOfRowsBetweenUpDownBorders == 0) {
            numberOfRowsBetweenUpDownBorders = 2;
        } else {
            numberOfRowsBetweenUpDownBorders += 3;
        }

        int numberOfLeftSpacesOnFrame = position.getWhiteSpaceLeft(),

            lengthOfTheMainMessage = (mainMessageFinalWithPosition.stylizedMessageAttributes()
                .getCompleteProcessing().length()),

            whereTextBegins = (numberOfChars / 2) - (lengthOfTheMainMessage / 2);

        sb.append("\n".repeat(position.getWhiteSpaceUp()));

        int i = 0;
        sb.append(" ".repeat(numberOfLeftSpacesOnFrame))
                .append(String.valueOf(upAndDownFrameChar).repeat(numberOfChars));

        while (++i < numberOfRowsBetweenUpDownBorders) {
            sb.append("\n").append(" ".repeat(numberOfLeftSpacesOnFrame))
                    .append(leftRightFrameChar);

            if (i == (numberOfRowsBetweenUpDownBorders / 2)) {
                        sb.append(" ".repeat(whereTextBegins - 1))
                        .append(mainMessageFinalWithPosition.getCompleteProcessing())
                        .append(" ".repeat(whereTextBegins - 1));
            } else {
                    sb.append(" ".repeat(numberOfChars - 2));
            }

            sb.append(leftRightFrameChar);
        }

        sb.append("\n").append(" ".repeat(numberOfLeftSpacesOnFrame))
                .append(String.valueOf(upAndDownFrameChar).repeat(numberOfChars));

        if (withSecondaryMessage) {
            int lengthOfTheSecondaryMsg = secondaryMessage.stylizedMessageAttributes().getHeaderMessage().length(),
                    whereToPutSecondaryMsg = ((numberOfChars / 2) - (lengthOfTheSecondaryMsg / 2));

            sb.append("\n")
                    .append(" ".repeat(position.getWhiteSpaceLeft()))
                    .append(" ".repeat(whereToPutSecondaryMsg))
                    .append(secondaryMessage.toString())
                    .append(" ".repeat(whereToPutSecondaryMsg));
        }


        sb.append("\n".repeat(position.getWhiteSpaceDown()));
        return sb.toString();
    }

    public static HFrameWithContent addClassicFrameWithCharsUpAndBellow(Character upAndDownFrameChar, int numberOfChars,
                                                             IStylizedMessage msg, CPosition position) {

        return new HFrameWithContent(upAndDownFrameChar, numberOfChars, position, msg);
    }

    public static HFrameWithContent addClassicFrameWithCharsOnAllSides(Character upAndDownFrameChar, Character leftAndRightChar,
                                                            int numberOfChars, IStylizedMessage msg, CPosition position,
                                                            boolean withSecondaryMessage, IStylizedMessage secondaryMessage) {
        return new HFrameWithContent(upAndDownFrameChar, leftAndRightChar, numberOfChars, position, msg,
                withSecondaryMessage, secondaryMessage);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public HFrameWithContent frameWithContentAttributes() {
        return this;
    }

    @Override
    public String toString() {
        return finalMessageWithFrame;
    }
}
