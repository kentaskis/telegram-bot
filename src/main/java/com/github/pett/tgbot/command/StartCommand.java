package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;

public class StartCommand extends AbstractCommand {
    public static final String START_MESSAGE = "Hi! I am Telegram Bot. I can you help.";

    protected StartCommand(SendBotMessageService sendBotMessageService) {
        super(sendBotMessageService);
    }

    @Override
    public String getMessage() {
        return START_MESSAGE;
    }
}