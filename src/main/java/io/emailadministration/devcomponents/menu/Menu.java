package io.emailadministration.devcomponents.menu;

import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import io.emailadministration.devcomponents.auxiliary.Position.CPositionNullObject;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.header.HeaderNullObject;
import io.emailadministration.devcomponents.header.IHeader;
import lombok.Getter;

import java.util.NavigableSet;
import java.util.TreeSet;

@Getter
public class Menu implements IMenu {
    private IHeader header;
    private int numberOfEntriesInTheCurrentMenu;
    private NavigableSet<String> optionsForTheMenu;
    private CPosition position;
    private IAuxMessage auxiliaryMessage;

    public Menu() {
        this.header = new HeaderNullObject();
        this.numberOfEntriesInTheCurrentMenu = 0;
        this.optionsForTheMenu = new TreeSet<>();
        this.position = new CPositionNullObject();
        this.auxiliaryMessage = new AuxiliaryMessageNullObject();
    }

    public Menu(IMenu menu) {
        this.header = new Header(menu.getMenu().header);
        this.numberOfEntriesInTheCurrentMenu = menu.getMenu().numberOfEntriesInTheCurrentMenu;
        this.optionsForTheMenu = new TreeSet<>(menu.getMenu().optionsForTheMenu);
        this.position = new CPosition(menu.getMenu().position);
        this.auxiliaryMessage = menu.getMenu().auxiliaryMessage;
    }

    @Override
    public IMenu withHeader(Header header) {
        return null;
    }

    @Override
    public IMenu withAuxiliaryMessage(IAuxMessage message) {
        return null;
    }

    @Override
    public IMenu onlyMenu() {
        return null;
    }

    @Override
    public Menu getMenu() {
        return this;
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
