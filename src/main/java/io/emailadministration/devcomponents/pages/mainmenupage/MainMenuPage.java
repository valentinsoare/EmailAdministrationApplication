package io.emailadministration.devcomponents.pages.mainmenupage;

import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.header.HeaderBuilder;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.header.message.MessageBuilder;
import io.emailadministration.devcomponents.header.message.MessageStyle;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.menu.usingmenu.MenuBuilder;
import io.emailadministration.devcomponents.pages.GenericPage;

public class MainMenuPage {
    private GenericPage genericPage;

    public MainMenuPage() {
        this.genericPage = new GenericPage();
    }

    public IMenu generatePage() {
        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,6, 4))
                .setupHeaderMessage("using my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setMainMessage(usingMyEmail);

        IStylizedMessage lovingSendingEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 1, 0))
                .setupHeaderMessage("love sending email")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setSecondaryMessage(lovingSendingEmail);

        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,usingMyEmail,
                new CPosition(2, 2, 12, 0),
                true, lovingSendingEmail);
        this.genericPage.setHFrameWithContent(hFrameWithContent);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(true)
                .build();
        this.genericPage.setHeader(h);

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 0))
                .setupNumberOfEntriesInTheCurrentMenu(15)
                .setupEntries("add employee, change employee, add user, change user, get employees, get users, " +
                        "remove employee, remove user, change password, change email, set user mailbox capacity, " +
                        "set alternate email address, change current user, help, quit")
                .setupAuxiliaryMessage(
                            new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                            )
                    )
                .build();

        this.genericPage.setMenu(m);
        return m;
    }
}
