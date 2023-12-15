package com.github.pett.tgbot.service;

/**
 * Service for sending message via telegram-bot
 */
public interface SendBotMessageService {
    /**
     * Send message via telegram-bot
     *
     * @param chatId provided chatId in which message would be sent
     * @param message provided message to be sent
     */
    void sendMessage(String chatId,String message);
}