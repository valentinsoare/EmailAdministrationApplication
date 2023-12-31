package io.emailadministration.devcomponents.menu.usingmenu;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.auxiliary.position.CPositionNullObject;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.header.HeaderNullObject;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessage;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessageNullObject;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;
import io.emailadministration.entities.businesscomponents.digitalcomponents.User;
import io.emailadministration.entities.businesscomponents.digitalcomponents.UserNullObject;
import io.emailadministration.printing.PrintError;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Menu implements IMenu {
    private IHeader header;
    private int numberOfEntriesInTheCurrentMenu;
    private List<String> optionsForTheMenu;
    private CPosition position;
    private IAuxMessage auxiliaryMessage;
    private User currentUser = new UserNullObject();

    public Menu() {
        this.header = new HeaderNullObject();
        this.numberOfEntriesInTheCurrentMenu = 0;
        this.optionsForTheMenu = new ArrayList<>(List.of("no options available"));
        this.position = new CPositionNullObject();
        this.auxiliaryMessage = new AuxiliaryMessageNullObject();
    }

    public Menu(IHeader header, int numberOfEntriesInTheCurrentMenu,
                CPosition position, IAuxMessage auxiliaryMessage) {
        setHeader(header);
        setNumberOfEntriesInTheCurrentMenu(numberOfEntriesInTheCurrentMenu);

        this.optionsForTheMenu = new ArrayList<>();

        setPosition(position);
        setAuxiliaryMessage(auxiliaryMessage);
    }

    public Menu(IMenu menu) {
        this.header = new Header(menu.menuAttributes().header);
        this.numberOfEntriesInTheCurrentMenu = menu.menuAttributes().numberOfEntriesInTheCurrentMenu;
        this.optionsForTheMenu = new ArrayList<>(menu.menuAttributes().optionsForTheMenu);
        this.position = new CPosition(menu.menuAttributes().position);
        this.auxiliaryMessage = new AuxiliaryMessage(menu.menuAttributes().auxiliaryMessage);
        this.currentUser = menu.menuAttributes().getCurrentUser();
    }

    public static IMenu getNewInstance(IMenu menu) {
        return new Menu(menu);
    }

    public void creatingMenuEntries(String menuEntries) {
        try {
            class ProcessingEntries {
                private ProcessingEntries() {}

                private static String[] processMenuEntries(String[] entries) {
                    for (int i = 0; i < entries.length; i++) {
                        entries[i] = (Arrays.stream(entries[i].split(" "))
                                .map(StringUtils::capitalize)
                                .collect(Collectors.joining(" "))).trim();
                    }

                    return entries;
                }
            }

            this.optionsForTheMenu = new ArrayList<>(
                    Arrays.asList(ProcessingEntries.processMenuEntries(SanityChecks.validateInputEntriesForMenu(
                            menuEntries, numberOfEntriesInTheCurrentMenu, position.getWhiteSpaceLeft()).split(",")))
            );
        } catch (InterruptedException e) {
            System.out.printf("ERROR - [creatingMenuEntries] - %s", e.getMessage());
        }
    }

    public boolean clearOptionsForMenu() {
        if (!optionsForTheMenu.isEmpty()) {
            optionsForTheMenu.clear();
            numberOfEntriesInTheCurrentMenu = 0;
            return true;
        }

        return false;
    }

    public boolean addMenuOptionAtAnIndex(int index, String optionFromUser) {
        try {
            if (index < 0 || index > optionsForTheMenu.size()) {
                PrintError.toConsole(InputErrors.INDEX_FOR_MENU_OPTION_NOT_VALID, position.getWhiteSpaceLeft(), 1000,
                        false, false);
                return false;
            }

            String resultAfterChecking = SanityChecks.checkMessage(optionFromUser, false, false, position.getWhiteSpaceLeft(),
                    false, false, InputErrors.NULL_OR_BLANK_MENU_OPTION_GIVEN);

            if (("none".equals(resultAfterChecking)) ||
                    (optionsForTheMenu.contains(resultAfterChecking))) {
                return false;
            }

            numberOfEntriesInTheCurrentMenu++;
            optionsForTheMenu.add(index, resultAfterChecking);

            return true;
        } catch (InterruptedException e) {
            System.out.printf("ERROR - [addMenuOptionAtAnIndex] - %s", e.getMessage());
        }

        return false;
    }

    public boolean addMenuOption(String optionFromUser) {
        String resultAfterChecking = SanityChecks.checkMessage(optionFromUser, false, false, position.getWhiteSpaceLeft(),
                false, false, InputErrors.NULL_OR_BLANK_MENU_OPTION_GIVEN);

        if (("none".equals(resultAfterChecking)) ||
                (optionsForTheMenu.contains(resultAfterChecking))) {
            return false;
        }

        numberOfEntriesInTheCurrentMenu++;
        optionsForTheMenu.add(resultAfterChecking);

        return true;
    }

    @Override
    public Menu menuAttributes() {
        return this;
    }

    public void setHeader(IHeader header) {
        this.header = header;
    }

    public void setNumberOfEntriesInTheCurrentMenu(int numberOfEntriesInTheCurrentMenu) {
        this.numberOfEntriesInTheCurrentMenu = numberOfEntriesInTheCurrentMenu;
    }

    public void setPosition(CPosition position) {
        this.position = SanityChecks.checkPosition(position);
    }

    public void setAuxiliaryMessage(IAuxMessage auxiliaryMessage) {
        this.auxiliaryMessage = SanityChecks.checkAuxiliaryMessage(auxiliaryMessage, position.getWhiteSpaceLeft(),
                false, true, StructuralErrors.NO_VALID_AUXILIARY_MENU_MESSAGE);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static IMenu createMenuInstance() {
        return new Menu();
    }

    public static IMenu createNewMenuInstance(IHeader header, int numberOfEntriesInTheCurrentMenu,
                                              CPosition position, IAuxMessage auxiliaryMessage) {
        return new Menu(header, numberOfEntriesInTheCurrentMenu, position, auxiliaryMessage);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
