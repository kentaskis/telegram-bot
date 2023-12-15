package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

class AbstractCommandTest {
    private static final String MESSAGE = "Test Message";
    private static final String COMMAND = "/test";
    private static final Long CHAT_ID = 123456L;

    @Test
    void shouldProperlyExecuteCommand() {
        // Arrange
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        AbstractCommand command = new AbstractCommand(sendBotMessageService) {
            @Override
            public String getMessage() {
                return MESSAGE;
            }
        };
        Update update = new Update();
        Message mockMessage = Mockito.mock(Message.class);
        Mockito.when(mockMessage.getText()).thenReturn(COMMAND);
        Mockito.when(mockMessage.getChatId()).thenReturn(CHAT_ID);
        update.setMessage(mockMessage);

        // Act
        command.execute(update);

        // Assert
        Mockito.verify(sendBotMessageService, Mockito.times(1)).sendMessage(CHAT_ID.toString(), command.getMessage());
    }
}