package io.emailadministration.devcomponents.menu.usingmenu;

import io.emailadministration.devcomponents.auxiliary.checks.SanityChecks;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.auxiliary.position.CPositionNullObject;
import io.emailadministration.devcomponents.logging.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.logging.errorsclasification.StructuralErrors;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.header.HeaderNullObject;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessage;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessageNullObject;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;
import io.emailadministration.entities.digitalcomponents.User;
import io.emailadministration.entities.digitalcomponents.UserNullObject;
import io.emailadministration.printing.PrintError;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Menu implements IMenu {
    private IHeader header;
    private int numberOfEntriesInTheCurrentMenu;
    private List<String> optionsForTheMenu;
    private CPosition position;
    private IAuxMessage auxiliaryMessage;
    private User currentUser = new UserNullObject();
    private Map<String, Object> storingInputValuesFromUser;
    private String additionalMessageAsANote;

    public Menu() {
        this.header = new HeaderNullObject();
        this.numberOfEntriesInTheCurrentMenu = 0;
        this.optionsForTheMenu = new ArrayList<>(List.of("no options available"));
        this.position = new CPositionNullObject();
        this.auxiliaryMessage = new AuxiliaryMessageNullObject();
        this.storingInputValuesFromUser = new HashMap<>();
        this.additionalMessageAsANote = "none";
    }

    public Menu(IHeader header, int numberOfEntriesInTheCurrentMenu,
                CPosition position, IAuxMessage auxiliaryMessage) {
        setHeader(header);
        setNumberOfEntriesInTheCurrentMenu(numberOfEntriesInTheCurrentMenu);

        this.optionsForTheMenu = new ArrayList<>();

        setPosition(position);
        setAuxiliaryMessage(auxiliaryMessage);

        this.storingInputValuesFromUser = new HashMap<>();
        this.additionalMessageAsANote = "none";
    }

    public Menu(IMenu menu) {
        this.header = new Header(menu.menuAttributes().header);
        this.numberOfEntriesInTheCurrentMenu = menu.menuAttributes().numberOfEntriesInTheCurrentMenu;
        this.optionsForTheMenu = new ArrayList<>(menu.menuAttributes().optionsForTheMenu);
        this.position = new CPosition(menu.menuAttributes().position);
        this.auxiliaryMessage = new AuxiliaryMessage(menu.menuAttributes().auxiliaryMessage);
        this.currentUser = menu.menuAttributes().getCurrentUser();
        this.storingInputValuesFromUser = new HashMap<>(menu.menuAttributes().getStoringInputValuesFromUser());
        this.additionalMessageAsANote = menu.menuAttributes().getAdditionalMessageAsANote();
    }

    public boolean addInputValueFromUser(String key, Object value) {
        return (storingInputValuesFromUser.computeIfAbsent(key, k -> value) != null);
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

    public void setPosition(CPosition position) {
        this.position = SanityChecks.checkPosition(position);
    }

    public void setAuxiliaryMessage(IAuxMessage auxiliaryMessage) {
        this.auxiliaryMessage = SanityChecks.checkAuxiliaryMessage(auxiliaryMessage, position.getWhiteSpaceLeft(),
                false, true, StructuralErrors.NO_VALID_AUXILIARY_MENU_MESSAGE);
    }

    public static IMenu createMenuInstance() {
        return new Menu();
    }

    public static IMenu createNewMenuInstance(IHeader header, int numberOfEntriesInTheCurrentMenu,
                                              CPosition position, IAuxMessage auxiliaryMessage) {
        return new Menu(header, numberOfEntriesInTheCurrentMenu, position, auxiliaryMessage);
    }

    public void setAdditionalMessageAsANote(String additionalMessageAsANote) {
        this.additionalMessageAsANote = SanityChecks.checkMessage(additionalMessageAsANote, false, true,
                position.getWhiteSpaceLeft(), false, true, InputErrors.NULL_OR_EMPTY_TEXT);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public IMenu getPresentObject() {
        return this;
    }

    public IMenu getCopyInstance(IMenu object) {
        Menu menu = object.menuAttributes();
        return new Menu(menu);
    }
}
