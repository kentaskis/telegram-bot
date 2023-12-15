package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public abstract String getMessage();

    protected AbstractCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), getMessage());
    }
}