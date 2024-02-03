package io.emailadministration.devcomponents.logging;

import lombok.Getter;

@Getter
public enum LogLevel {
    TRACE(6),
    DEBUG(5),
    INFO(4),
    WARN(3),
    ERROR(2),
    FATAL(1),
    OFF(0);

    private final int levelAsInteger;

    LogLevel(int levelAsInteger) {
        this.levelAsInteger = levelAsInteger;
    }
}
