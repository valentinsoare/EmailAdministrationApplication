package io.emailadministration.devcomponents.pages.loginsignuppage;

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
public class LoginSignUpPage {
    private GenericPage genericPage;

    public LoginSignUpPage() {
        this.genericPage = new GenericPage();
    }

    public IMenu generatePage() {
        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(1, 10,11, 0))
                .setupHeaderMessage("my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.ASCII)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setMainMessage(usingMyEmail);
        CachedObjects.addObjectInCache("defaultMainMsgLogo", usingMyEmail);

        IStylizedMessage signInSignUp = new MessageBuilder()
                .setupPosition(new CPosition(1, 2, 34, 0))
                .setupHeaderMessage("Sign In Sign Up")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.genericPage.setSecondaryMessage(signInSignUp);
        CachedObjects.addObjectInCache("defaultSecondaryMsgLogo", signInSignUp);


        HFrameWithContent hFrame = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,usingMyEmail,
                new CPosition(0, 0, 12, 0),
                true, signInSignUp);
        this.genericPage.setHFrameWithContent(hFrame);
        CachedObjects.addObjectInCache("defaultHFrameLogo", hFrame);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrame)
                .setupAllBorders(false)
                .build();
        this.genericPage.setHeader(h);
        CachedObjects.addObjectInCache("headerWithoutAllBordersLogo", h);


        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(5)
                .setupEntries("sign in, sign up, go to main menu, help, quit")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                        )
                )
                .build();
        CachedObjects.addObjectInCache("menuWithHeaderLogo", m);

        this.genericPage.setMenu(m);
        return m;
    }
}
