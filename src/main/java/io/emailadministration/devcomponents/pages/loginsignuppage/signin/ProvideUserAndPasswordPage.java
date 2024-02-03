package io.emailadministration.devcomponents.pages.loginsignuppage.signin;

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
import io.emailadministration.devcomponents.pages.IPage;
import org.hibernate.query.Page;

public class ProvideUserAndPasswordPage implements IPage {

    private final GenericPage page;

    public ProvideUserAndPasswordPage() {
        this.page = new GenericPage();
    }

    @Override
    public IMenu generatePage() {
        IStylizedMessage withMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,6, 2))
                .setupHeaderMessage("use my email ")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        this.page.setMainMessage(withMyEmail);
        CachedObjects.addObjectInCache("mainMessageModern", withMyEmail);

        IStylizedMessage userSignIn = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 2, 0))
                .setupHeaderMessage("user sign in")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.page.setSecondaryMessage(userSignIn);
        CachedObjects.addObjectInCache("secondaryMessageClassic", userSignIn);

        HFrameWithContent hFrame = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,withMyEmail,
                new CPosition(0, 2, 12, 0),
                true, userSignIn);
        this.page.setHFrameWithContent(hFrame);
        CachedObjects.addObjectInCache("defaultFrame", hFrame);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrame)
                .setupAllBorders(true)
                .build();
        this.page.setHeader(h);
        CachedObjects.addObjectInCache("headerClassicAllBorders", h);

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupAdditionalMessageAsANote("please provide the username and password for login separated by a comma!")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("Username and password (back/quit):",
                                new CPosition(0, 0, 1, 0)
                        )
                )
                .build();
        this.page.setMenu(m);
        CachedObjects.addObjectInCache("menuWithClassicHeader", m);

        return m;
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public IPage getPresentObject() {
        return this;
    }
}
