package io.emailadministration.devcomponents.header;

import io.emailadministration.devcomponents.header.frame.HFrameWithContent;

public class HeaderBuilder {
    private IHeader header;

    public HeaderBuilder() {
        this.header = new Header();
    }

    public HeaderBuilder setupFrameWithMessage(HFrameWithContent frameWithContent) {
        header.headerAttributes().setFrameWithMainMessage(frameWithContent);
        return this;
    }

    public HeaderBuilder setupAllBorders(boolean allBorders) {
        header.headerAttributes().setAllBorders(allBorders);
        return this;
    }

    public IHeader build() {
        return header.headerAttributes().headerWithAllTrimmings();
    }
}
