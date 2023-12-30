package io.emailadministration.devcomponents.mainmenupage;

import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.IFrame;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

public interface MainMenuPageI {
    IHeader extractHeader();
    IStylizedMessage extractMainMessage();
    IStylizedMessage extractSecondaryMessage();
    IFrame extractFrame();
    IMenu extractMenu();
    IMenu generateMainMenuPage();
}
