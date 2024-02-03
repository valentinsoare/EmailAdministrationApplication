package io.emailadministration.devcomponents.pages.loginsignuppage.help;

import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.pages.GenericPage;
import io.emailadministration.devcomponents.pages.IPage;
import org.hibernate.query.Page;

public class HelpPageForSignInSignUp implements IPage {
    @Override
    public IMenu generatePage() {
        return null;
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public IPage getPresentObject() {
        return this;
    }
}
