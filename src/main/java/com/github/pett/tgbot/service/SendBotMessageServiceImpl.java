package com.github.pett.tgbot.service;

import com.github.pett.tgbot.bot.JavaTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface
 */
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavaTelegramBot telegramBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaTelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo: add logging
            e.printStackTrace();
        }
    }
}