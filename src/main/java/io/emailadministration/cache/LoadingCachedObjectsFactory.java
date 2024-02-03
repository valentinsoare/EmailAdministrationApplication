package io.emailadministration.cache;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

import java.util.Map;

public class LoadingCachedObjectsFactory {

    private LoadingCachedObjectsFactory() {}

    private static Map<String, Component> objects;

    static {
        objects = CachedObjects.loadCachedObjects();
    }

    public static IStylizedMessage loadMainMessageModern() {
        return (IStylizedMessage) objects.get("mainMessageModern");
    }

    public static IStylizedMessage loadSecondaryMessageClassic() {
        return (IStylizedMessage) objects.get("secondaryMessageClassic");
    }

    public static HFrameWithContent loadDefaultFrame() {
        return (HFrameWithContent) objects.get("defaultFrame");
    }

    public static IStylizedMessage loadDefaultMainMsgLogo() {
        return (IStylizedMessage) objects.get("defaultMainMsgLogo");
    }

    public static IStylizedMessage loadDefaultSecondaryMsgLogo() {
        return (IStylizedMessage) objects.get("defaultSecondaryMsgLogo");
    }

    public static HFrameWithContent loadDefaultHFrameLogo() {
        return (HFrameWithContent) objects.get("defaultHFrameLogo");
    }

    public static IHeader loadHeaderWithoutAllBordersLogo() {
        return (IHeader) objects.get("headerWithoutAllBordersLogo");
    }

    public static IHeader loadHeaderClassicAllBorders() {
        return (IHeader) objects.get("headerClassicAllBorders");
    }

    public static IMenu loadMenuWithClassicHeader() {
        return (IMenu) objects.get("menuWithClassicHeader");
    }

    public static IMenu loadMenuWithHeaderLogo() {
        return (IMenu) objects.get("menuWithHeaderLogo");
    }
}
