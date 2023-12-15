package com.github.pett.tgbot.command;

import com.github.pett.tgbot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands
 */
public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getComName(), new StartCommand(sendBotMessageService))
                .put(CommandName.STOP.getComName(), new StopCommand(sendBotMessageService))
                .put(CommandName.HELP.getComName(), new HelpCommand(sendBotMessageService))
                .put(CommandName.NO.getComName(), new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}