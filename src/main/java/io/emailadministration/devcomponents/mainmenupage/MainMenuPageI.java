package io.emailadministration.devcomponents.mainmenupage;

import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

public interface MainMenuPageI {
    IHeader extractHeader();
    IMenu generateMainMenuPage();
}
