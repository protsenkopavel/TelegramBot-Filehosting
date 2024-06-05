package net.protsenko.bot;

import net.protsenko.config.TelegramProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component

public class TelegramBot extends TelegramWebhookBot {

    TelegramProperties properties;

    public TelegramBot(TelegramProperties properties) throws TelegramApiException {
        super(properties.getToken());
        this.properties = properties;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        System.out.println(text);
        return null;
    }

    @Override
    public String getBotPath() {
        return properties.getUrl();
    }

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

}
