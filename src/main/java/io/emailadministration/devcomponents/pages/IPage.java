package io.emailadministration.devcomponents.pages;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;

public interface IPage extends Component<IPage> {
    IMenu generatePage();
}
