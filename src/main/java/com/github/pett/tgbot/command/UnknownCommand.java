package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;

public class UnknownCommand extends AbstractCommand {
    public static final String UNKNOWN_MESSAGE = "I don't understand you \uD83D\uDE1F, type /help to find out what I understand.";

    @Override
    public String getMessage() {
        return UNKNOWN_MESSAGE;
    }

    protected UnknownCommand(SendBotMessageService sendBotMessageService) {
        super(sendBotMessageService);
    }
}