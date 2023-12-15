package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;

public class NoCommand extends AbstractCommand {
    public static final String NO_MESSAGE = "I support commands starting with a slash (/).\n"
            + "To view the list of commands, enter /help";

    @Override
    public String getMessage() {
        return NO_MESSAGE;
    }

    protected NoCommand(SendBotMessageService sendBotMessageService) {
        super(sendBotMessageService);
    }
}