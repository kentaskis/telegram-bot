package com.github.pett.tgbot.command;

/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("");

    private final String comName;

    CommandName(String commandName) {
        this.comName = commandName;
    }

    public String getComName() {
        return comName;
    }
}