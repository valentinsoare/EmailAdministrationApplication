package io.emailadministration.devcomponents;

public interface Component<T> {
    String getTypeOfObject();
    T getPresentObject();
}
