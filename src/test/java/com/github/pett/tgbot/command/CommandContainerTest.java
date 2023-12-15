package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    void setUp() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getComName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });

    }

    @Test
    void shouldReturnUnknownCommand() {
        //init variables
        String unknownCommand = "/abrakadabra";

        //voraussetzung
        Command command = commandContainer.retrieveCommand(unknownCommand);

        //verification
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}