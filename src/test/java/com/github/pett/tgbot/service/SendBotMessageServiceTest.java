package com.github.pett.tgbot.service;

import com.github.pett.tgbot.bot.JavaTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private JavaTelegramBot javaTelegramBot;

    @BeforeEach
    public void init() {
        javaTelegramBot = Mockito.mock(JavaTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaTelegramBot);
    }

    @Test
    void shouldProperlySendMessage() throws TelegramApiException {
        // init variables
        String charId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(charId);
        sendMessage.enableHtml(true);

        //voraussetzung
        sendBotMessageService.sendMessage(charId,message);

        //verification
        Mockito.verify(javaTelegramBot).execute(sendMessage);
    }
}