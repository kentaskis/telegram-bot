package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;

import static com.github.pett.tgbot.command.CommandName.*;

public class HelpCommand extends AbstractCommand {
    public static final String HELP_MESSAGE = String.format("✨<b>Available commands</b>✨\n\n"
                    + "<b>Start/stop interacting with the bot</b>\n"
                    + "%s - start interacting with me\n"
                    + "%s - pause interacting with me\n\n"
                    + "%s - get help with interacting with me\n",
            START.getComName(), STOP.getComName(), HELP.getComName());

    @Override
    public String getMessage() {
        return HELP_MESSAGE;
    }

    protected HelpCommand(SendBotMessageService sendBotMessageService) {
        super(sendBotMessageService);
    }
}