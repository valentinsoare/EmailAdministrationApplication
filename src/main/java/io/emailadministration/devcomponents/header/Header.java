package io.emailadministration.devcomponents.header;

import io.emailadministration.devcomponents.header.frame.HFrameWithContentNullObject;
import io.emailadministration.printing.PrintError;
import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import lombok.Getter;

@Getter
public class Header implements IHeader {
    private HFrameWithContent frameWithMessage;
    private boolean allBorders;
    private String frameWithMessageAsString;

    public Header() {
        this.frameWithMessage = new HFrameWithContentNullObject();
        this.allBorders = true;
        this.frameWithMessageAsString = "none";
    }

    public Header(boolean allBorders, HFrameWithContent frameWithMessage) {
        this.allBorders = allBorders;

        setFrameWithMainMessage(frameWithMessage);

        if (allBorders) {
            frameWithMessageAsString = frameWithMessage.generateFrameWithMessageAndCharsAllAround();
        } else {
            frameWithMessageAsString = frameWithMessage.generateFrameWithMessageAndCharsOnUpDownBorders();
        }
    }

    public Header(IHeader header) {
        this(header.headerAttributes().isAllBorders(),
                new HFrameWithContent(header.headerAttributes().getFrameWithMessage()));

    }

    public void setFrameWithMainMessage(HFrameWithContent frameWithMessage) {
        HFrameWithContent hFrameWithContent = SanityChecks.checkFrame(frameWithMessage);

        try {
            if ("HFrameWithContentNullObject".equals(hFrameWithContent.getTypeOfObject())) {
                PrintError.toConsole(StructuralErrors.NO_AVAILABLE_FRAME_FOR_HEADER, 2, 200,
                        false, true);
            } else {
                this.frameWithMessage = frameWithMessage;
            }
        } catch (InterruptedException e) {
            System.out.printf("%nERROR - [setFrameForHeader] - %s", e.getMessage());
        }
    }

    public static IHeader generateHeader(boolean allBorders, HFrameWithContent frameWithMessage) {
        return new Header(allBorders, frameWithMessage);
    }

    public IHeader headerWithAllTrimmings() {
        return new Header(allBorders, frameWithMessage);
    }

    @Override
    public String toString() {
        return String.format("%s",frameWithMessageAsString);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Header headerAttributes() {
        return this;
    }

    public void setAllBorders(boolean allBorders) {
        this.allBorders = allBorders;
    }
}
