package org.azati.tgbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("bot")
public record BotConfig(
    String name,
    String token
) {}
