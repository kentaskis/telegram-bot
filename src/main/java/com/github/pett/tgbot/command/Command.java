package com.github.pett.tgbot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command Interface for handling telegram-bot commands
 */
public interface Command {

    /**
     * Main method, with is executing command logic
     *
     * @param update provided {@link Update} object with all needed data for command
     */
    void execute(Update update);
}