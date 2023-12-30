package io.emailadministration.devcomponents.loginpage;

import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.IFrame;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

public interface LoginPageI {
    IMenu generateLoginOrSignUpPage();
    IHeader extractHeader();
    IFrame extractFrame();
    IStylizedMessage extractMainMessage();
    IStylizedMessage extractSecondaryMessage();
    IMenu extractMenu();
}
