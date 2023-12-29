package io.emailadministration.devcomponents.header;

public class HeaderNullObject extends Header {
    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Header headerAttributes() {
        return this;
    }
}
