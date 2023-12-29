package io.emailadministration.devcomponents.header.Frame;

public class HFrameWithContentNullObject extends HFrameWithContent {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public HFrameWithContent getHFrameWithContent() {
        return this;
    }
}
