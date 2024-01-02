package io.emailadministration.devcomponents.menu.usingmenu;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;
import io.emailadministration.entities.businesscomponents.digitalcomponents.User;

public class MenuBuilder {
    private IMenu menu;

    public MenuBuilder() {
        this.menu = new Menu();
    }

    public MenuBuilder setupHeader(IHeader header) {
        menu.menuAttributes().setHeader(SanityChecks.checkHeader(header));
        return this;
    }

    public MenuBuilder setupNumberOfEntriesInTheCurrentMenu(int numberOfEntriesInTheCurrentMenu) {
        menu.menuAttributes().setNumberOfEntriesInTheCurrentMenu(numberOfEntriesInTheCurrentMenu);
        return this;
    }

    public MenuBuilder setupPosition(CPosition position) {
        menu.menuAttributes().setPosition(position);
        return this;
    }

    public MenuBuilder setupAuxiliaryMessage(IAuxMessage auxiliaryMessage) {
        menu.menuAttributes().setAuxiliaryMessage(auxiliaryMessage);
        return this;
    }

    public MenuBuilder setupEntries(String menuEntries) {
        menu.menuAttributes().creatingMenuEntries(menuEntries);
        return this;
    }

    public MenuBuilder addAnOptionInMenuEntries(String option) {
        menu.menuAttributes().addMenuOption(option);
        return this;
    }

    public MenuBuilder addAnOptionAtAnIndexInMenuEntries(int index, String option) {
        menu.menuAttributes().addMenuOptionAtAnIndex(index, option);
        return this;
    }

    public MenuBuilder clearMenuOptions() {
        menu.menuAttributes().clearOptionsForMenu();
        return this;
    }

    public MenuBuilder setupCurrentUSer(User user) {
        menu.menuAttributes().setCurrentUser(user);
        return this;
    }

    public MenuBuilder setupAdditionalMessageAsANote(String additionalMessage) {
        menu.menuAttributes().setAdditionalMessageAsANote(additionalMessage);
        return this;
    }

    public IMenu build() {
        return menu;
    }
}
