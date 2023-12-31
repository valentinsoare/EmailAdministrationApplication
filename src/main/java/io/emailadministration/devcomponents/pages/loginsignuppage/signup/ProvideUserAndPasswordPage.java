package io.emailadministration.devcomponents.pages.loginsignuppage.signup;

import io.emailadministration.cache.LoadingCachedObjectsFactory;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.message.HMessage;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.GenericPage;

public class ProvideUserAndPasswordPage {
    private GenericPage page;

    public ProvideUserAndPasswordPage() {
        this.page = new GenericPage();
    }

    public IMenu generatePage() {
        IStylizedMessage mainMessage = LoadingCachedObjectsFactory.loadMainMessageModern();
        mainMessage.stylizedMessageAttributes().setHeaderMessage("To Use My Email");
        mainMessage.stylizedMessageAttributes().setPosition(
                new CPosition(0, 0, 6, 3)
        );
        mainMessage.stylizeIt(true, true);

        this.page.setMainMessage(mainMessage);


        IStylizedMessage secondaryMessage = new HMessage(LoadingCachedObjectsFactory.loadSecondaryMessageClassic());
        secondaryMessage.stylizedMessageAttributes().setHeaderMessage("provide user and password");
        secondaryMessage.stylizeIt(true, true);

        this.page.setSecondaryMessage(secondaryMessage);


        HFrameWithContent iFrame = LoadingCachedObjectsFactory.loadDefaultFrame();
        iFrame.frameWithContentAttributes().setMainMessage(mainMessage);
        iFrame.frameWithContentAttributes().setSecondaryMessage(secondaryMessage);
        iFrame.frameWithContentAttributes().generateFrameWithMessageAndCharsAllAround();

        this.page.setHFrameWithContent(iFrame);


        IHeader iHeader = new Header(LoadingCachedObjectsFactory.loadHeaderClassicAllBorders());
        iHeader.headerAttributes().setFrameWithMainMessage(iFrame);

        this.page.setHeader(iHeader);


        IMenu iMenu = LoadingCachedObjectsFactory.loadMenuWithClassicHeader();
        iMenu.menuAttributes().setHeader(iHeader);
        iMenu.menuAttributes().setNumberOfEntriesInTheCurrentMenu(4);
        iMenu.menuAttributes().creatingMenuEntries("user, password, back, quit");

        this.page.setMenu(iMenu);


        return iMenu;
    }
}
