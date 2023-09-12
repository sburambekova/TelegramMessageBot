package com.sandugash_burambekova;

import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalTime;
import java.util.UUID;

@ApplicationScoped
public class MessageCalculator {

    @Inject
    TelegramBot bot;

    @Scheduled(every = "30s")
    public void message() {
        String message = "Now it is " + LocalTime.now().withNano(0) + ": " + UUID.randomUUID();
        bot.sendMessage(message);
    }

}
