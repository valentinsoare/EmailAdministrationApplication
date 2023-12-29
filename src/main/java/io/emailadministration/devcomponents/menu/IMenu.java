package io.emailadministration.devcomponents.menu;

import io.emailadministration.devcomponents.header.Header;

public interface IMenu {
    IMenu withHeader(Header header);
    IMenu withAuxiliaryMessage(IAuxMessage message);
    IMenu onlyMenu();
    Menu getMenu();
    String getTypeOfObject();
}
