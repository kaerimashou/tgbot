package org.azati.tgbot.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.azati.tgbot.bot.TGBot;
import org.azati.tgbot.service.TGBotService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@AllArgsConstructor
@Slf4j
public class TGBotServiceImpl implements TGBotService {

    private TGBot tgBot;

    @Override
    public boolean sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            tgBot.execute(sendMessage);
            return true;
        } catch (TelegramApiException e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }
}
