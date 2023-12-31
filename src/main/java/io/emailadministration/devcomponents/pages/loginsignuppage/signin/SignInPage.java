package io.emailadministration.devcomponents.pages.loginsignuppage.signin;

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
import lombok.Getter;

@Getter
public class SignInPage extends GenericPage {
    private GenericPage genericPage;

    public SignInPage() {
        this.genericPage = new GenericPage();
    }

    public IMenu generatePage() {
        IStylizedMessage withMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,6, 3))
                .setupHeaderMessage("# with my email #")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setMainMessage(withMyEmail);

        IStylizedMessage userSignIn = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 1, 0))
                .setupHeaderMessage("user sign in")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setSecondaryMessage(userSignIn);

        HFrameWithContent hFrame = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,withMyEmail,
                new CPosition(2, 2, 12, 0),
                true, userSignIn);
        this.genericPage.setHFrameWithContent(hFrame);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrame)
                .setupAllBorders(true)
                .build();
        this.genericPage.setHeader(h);

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(4)
                .setupEntries("enter user and password, go to main menu, back, quit")
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
