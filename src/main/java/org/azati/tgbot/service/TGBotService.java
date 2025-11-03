package org.azati.tgbot.service;

public interface TGBotService {
    boolean sendMessage(Long chatId, String message);
}
