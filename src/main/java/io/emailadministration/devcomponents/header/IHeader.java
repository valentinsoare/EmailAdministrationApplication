package io.emailadministration.devcomponents.header;

import io.emailadministration.devcomponents.Component;

public interface IHeader extends Component {
    String getTypeOfObject();
    Header headerAttributes();
}
