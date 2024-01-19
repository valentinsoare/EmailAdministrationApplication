package io.emailadministration.devcomponents.header.frame;

import io.emailadministration.devcomponents.Component;

public interface IFrame extends Component<IFrame> {
    String getTypeOfObject();
    HFrameWithContent frameWithContentAttributes();
}
