package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;

public class StopCommand extends AbstractCommand {

    public static final String STOP_MESSAGE = "I have stop your subscription";

    protected StopCommand(SendBotMessageService sendBotMessageService) {
        super(sendBotMessageService);
    }

    @Override
    public String getMessage() {
        return STOP_MESSAGE;
    }
}