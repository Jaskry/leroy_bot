package com.home.leroy_bot.appconfig;

import com.home.leroy_bot.LeroyTelegramBot;
import com.home.leroy_bot.botapi.TelegramFacade;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;


    @Bean
    public LeroyTelegramBot LeroyTelegramBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = new DefaultBotOptions();

        LeroyTelegramBot telegramBot = new LeroyTelegramBot(options, telegramFacade);

        telegramBot.setBotToken(botToken);
        telegramBot.setBotUserName(botUserName);
        telegramBot.setWebHookPath(webHookPath);

        return telegramBot;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
