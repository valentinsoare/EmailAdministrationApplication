package io.emailadministration.devcomponents.menu.usingmenu;

import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;

public interface IMenu {
    IMenu withHeader(Header header);
    IMenu withAuxiliaryMessage(IAuxMessage message);
    IMenu onlyMenu();
    Menu getMenu();
    String getTypeOfObject();
}
