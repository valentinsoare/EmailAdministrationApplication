package io.emailadministration.devcomponents.mainmenupage;

import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.header.HeaderBuilder;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.frame.IFrame;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.header.message.MessageBuilder;
import io.emailadministration.devcomponents.header.message.MessageStyle;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.menu.usingmenu.MenuBuilder;

public class MainMenuPage implements MainMenuPageI {
    private IMenu mainMenu;
    private IHeader header;
    private IStylizedMessage mainMessage;
    private IStylizedMessage secondaryMessage;
    private IFrame hFrameWithContent;

    @Override
    public IMenu generateMainMenuPage() {
        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,5, 5))
                .setupHeaderMessage("using my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        this.mainMessage = usingMyEmail;


        IStylizedMessage lovingSendingEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 0, 0))
                .setupHeaderMessage("love sending email")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.secondaryMessage = lovingSendingEmail;


        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 40,usingMyEmail,
                new CPosition(2, 2, 12, 0),
                true, lovingSendingEmail);
        this.hFrameWithContent = hFrameWithContent;


        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(true)
                .build();
        this.header = h;

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 0))
                .setupNumberOfEntriesInTheCurrentMenu(14)
                .setupEntries("add employee, change employee, add user, change user, get employees, get users, " +
                        "remove employee, remove user, change password, " +
                        "change email, set user mailbox capacity, set alternate email address, help, quit")
                .setupAuxiliaryMessage(
                            new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                            )
                    )
                .build();

        this.mainMenu = m;
        return m;
    }

    @Override
    public IHeader extractHeader() {
        return header;
    }

    @Override
    public IStylizedMessage extractMainMessage() {
        return mainMessage;
    }

    @Override
    public IStylizedMessage extractSecondaryMessage() {
        return secondaryMessage;
    }

    @Override
    public IFrame extractFrame() {
        return hFrameWithContent;
    }

    @Override
    public IMenu extractMenu() {
        return mainMenu;
    }
}
