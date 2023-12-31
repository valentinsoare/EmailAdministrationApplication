package io.emailadministration.devcomponents.menu.auxmessage;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;

public interface IAuxMessage extends Component {
    String getTypeOfObject();
    AuxiliaryMessage auxiliaryMessageAttributes();
    String getProcessedAuxiliaryMessage();
    CPosition getPosition();
}
