package io.emailadministration.devcomponents.menu.usingmenu;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.menu.auxmessage.IAuxMessage;

public interface IMenu extends Component<IMenu> {
    Menu menuAttributes();
    String getTypeOfObject();
}
