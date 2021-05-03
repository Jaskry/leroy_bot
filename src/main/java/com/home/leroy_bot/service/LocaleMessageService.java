package com.home.leroy_bot.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Работает с файлом шаблоном "ответных сообщений" messages_ru_RU.properties
 *
 * @author Sergei Viacheslaev
 */
@Service
public class LocaleMessageService {
    private final Locale locale;
    private final MessageSource messageSource;

    public LocaleMessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag("ru-RU");
    }


    public String getMessage(String message) {
        return messageSource.getMessage(message, null, locale);
    }

    public String getMessage(String message, Object... args) {
        return messageSource.getMessage(message, args, locale);
    }

}
