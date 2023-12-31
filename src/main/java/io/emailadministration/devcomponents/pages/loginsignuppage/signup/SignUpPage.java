package io.emailadministration.devcomponents.pages.loginsignuppage.signup;

import io.emailadministration.cache.CachedObjects;
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
public class SignUpPage {
    private GenericPage genericPage;

    public SignUpPage() {
        this.genericPage = new GenericPage();
    }

    public IMenu generatePage() {
        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,6, 4))
                .setupHeaderMessage("my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setMainMessage(usingMyEmail);
        CachedObjects.addObjectInCache("mainMessageModern", usingMyEmail);

        IStylizedMessage signUp = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 0, 0))
                .setupHeaderMessage("sign up")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setSecondaryMessage(signUp);
        CachedObjects.addObjectInCache("secondaryMessageClassic", signUp);

        HFrameWithContent hFrame = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,usingMyEmail,
                new CPosition(2, 2, 12, 0),
                true, signUp);
        this.genericPage.setHFrameWithContent(hFrame);
        CachedObjects.addObjectInCache("defaultFrame", hFrame);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrame)
                .setupAllBorders(true)
                .build();
        this.genericPage.setHeader(h);
        CachedObjects.addObjectInCache("headerClassicAllBorders", h);

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(4)
                .setupEntries("provide user/Password, go to main menu, back, quit")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                        )
                )
                .build();
        this.genericPage.setMenu(m);
        CachedObjects.addObjectInCache("menuWithClassicHeader", m);

        return m;
    }
}
