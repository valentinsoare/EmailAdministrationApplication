package io.emailadministration.devcomponents.loginpage;

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
import io.emailadministration.devcomponents.menu.usingmenu.MenuNullObject;

public class LoginOrSignUp implements LoginPageI {
    private IMenu loginMenu;
    private IHeader header;

    private IStylizedMessage mainMessage;
    private IStylizedMessage secondaryMessage;
    private IFrame hFrameWithContent;

    public LoginOrSignUp() {
        this.loginMenu = new MenuNullObject();
    }

    @Override
    public IMenu generateLoginOrSignUpPage() {
        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(1, 10,11, 0))
                .setupHeaderMessage("my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.ASCII)
                .addStyleToTheMessage(true, true)
                .build();
        this.mainMessage = usingMyEmail;

        IStylizedMessage signInSignUp = new MessageBuilder()
                .setupPosition(new CPosition(1, 2, 34, 0))
                .setupHeaderMessage("sign in/sign up")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        this.secondaryMessage = signInSignUp;


        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,usingMyEmail,
                new CPosition(0, 0, 12, 0),
                true, signInSignUp);
        this.hFrameWithContent = hFrameWithContent;

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(false)
                .build();
        this.header = h;

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(4)
                .setupEntries("sign in, sign up, help, quit")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                        )
                )
                .build();
        this.loginMenu = m;

        return m;
    }

    @Override
    public IHeader extractHeader() {
        return header;
    }

    @Override
    public IFrame extractFrame() {
        return hFrameWithContent;
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
    public IMenu extractMenu() {
        return loginMenu;
    }
}
