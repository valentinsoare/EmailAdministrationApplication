package io.emailadministration.devcomponents.header.frame;

public class HFrameWithContentNullObject extends HFrameWithContent {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public HFrameWithContent frameWithContentAttributes() {
        return this;
    }
}
