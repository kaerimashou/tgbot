package org.azati.tgbot.bot;

import lombok.extern.slf4j.Slf4j;
import org.azati.tgbot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Slf4j
public class TGBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    public TGBot(BotConfig botConfig) {
        super(botConfig.token());
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.name();
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info(update.getMessage().getChatId().toString());
    }

}
