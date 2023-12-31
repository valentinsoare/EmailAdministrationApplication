package io.emailadministration.cache;

import io.emailadministration.devcomponents.Component;
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

import java.util.HashMap;
import java.util.Map;

public class CachedObjects {
    private final Map<String, Component> cachedObjects;

    public CachedObjects() {
        this.cachedObjects = new HashMap<>();
    }

    public void addObjectInCache(String key, Component item) {
        cachedObjects.put(key, item);
    }

    public Map<String, Component> loadCachedObjects() {
        IStylizedMessage defaultMainMsg = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,6, 4))
                .setupHeaderMessage("defaultMsg")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();
        cachedObjects.put("mainMessageModern", defaultMainMsg);

        IStylizedMessage defaultSecondaryMsg = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 1, 0))
                .setupHeaderMessage("defaultMSg")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        cachedObjects.put("secondaryMessageClassic", defaultSecondaryMsg);

        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,defaultMainMsg,
                new CPosition(2, 2, 12, 0),
                true, defaultSecondaryMsg);
        cachedObjects.put("defaultFrame", hFrameWithContent);

        IStylizedMessage defaultLogo = new MessageBuilder()
                .setupPosition(new CPosition(1, 10,11, 0))
                .setupHeaderMessage("my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.ASCII)
                .addStyleToTheMessage(true, true)
                .build();
        cachedObjects.put("defaultMainMsgLogo", defaultLogo);

        IStylizedMessage defaultSecLogo = new MessageBuilder()
                .setupPosition(new CPosition(1, 2, 34, 0))
                .setupHeaderMessage("defaultLogo")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();
        cachedObjects.put("defaultSecondaryMsgLogo", defaultSecLogo);

        HFrameWithContent hFrame = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 60,defaultLogo,
                new CPosition(0, 0, 12, 0),
                true, defaultSecLogo);
        cachedObjects.put("defaultHFrameLogo", hFrame);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrame)
                .setupAllBorders(false)
                .build();
        cachedObjects.put("headerWithoutAllBordersLogo", h);

        IHeader header = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(true)
                .build();
        cachedObjects.put("headerClassicAllBorders", header);

        IMenu menuWithClassicHeader = new MenuBuilder().setupHeader(header)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(4)
                .setupEntries("provide user/Password, go to main menu, back, quit")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                        )
                )
                .build();
        cachedObjects.put("menuWithClassicHeader", menuWithClassicHeader);

        IMenu menuWithHeaderLogo = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 12, 12))
                .setupNumberOfEntriesInTheCurrentMenu(5)
                .setupEntries("sign in, sign up, go to main menu, help, quit")
                .setupAuxiliaryMessage(
                        new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                        )
                )
                .build();
        cachedObjects.put("menuWithHeaderLogo", menuWithHeaderLogo);

        return cachedObjects;
    }
}
