package io.emailadministration.devcomponents.pages;

import io.emailadministration.devcomponents.header.HeaderNullObject;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContentNullObject;
import io.emailadministration.devcomponents.header.frame.IFrame;
import io.emailadministration.devcomponents.header.message.HMessageNullObject;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.menu.usingmenu.MenuNullObject;
import io.emailadministration.entities.digitalcomponents.User;
import io.emailadministration.entities.digitalcomponents.UserNullObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericPage {
    private IMenu menu;
    private IHeader header;

    private IStylizedMessage mainMessage;
    private IStylizedMessage secondaryMessage;
    private IFrame hFrameWithContent;
    private User currentUser;


    public GenericPage() {
        this.menu = new MenuNullObject();
        this.header = new HeaderNullObject();
        this.mainMessage = new HMessageNullObject();
        this.secondaryMessage = new HMessageNullObject();
        this.hFrameWithContent = new HFrameWithContentNullObject();
        this.currentUser = new UserNullObject();
    }

    protected GenericPage(IMenu menu, IHeader header, IStylizedMessage mainMessage,
                          IStylizedMessage secondaryMessage, IFrame hFrameWithContent,
                          User currentUser) {
        this.menu = menu;
        this.header = header;
        this.mainMessage = mainMessage;
        this.secondaryMessage = secondaryMessage;
        this.hFrameWithContent = hFrameWithContent;
        this.currentUser = currentUser;
    }

    public IHeader extractHeader() {
        return header;
    }

    public IFrame extractFrame() {
        return hFrameWithContent;
    }

    public IStylizedMessage extractMainMessage() {
        return mainMessage;
    }

    public IStylizedMessage extractSecondaryMessage() {
        return secondaryMessage;
    }

    public IMenu extractMenu() {
        return menu;
    }

    public User extractCurrentUser() {
        return currentUser;
    }
}
