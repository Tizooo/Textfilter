package me.tizo.textfilter;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.plugin.Plugin;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

@Plugin(
        id = "textfilter",
        name = "Textfilter",
        version = "1.0.0"
)

public class Textfilter {

    @Inject
    private Logger logger;

    // Define a list of blocked words
    private static final List<String> blockedWords = Arrays.asList("badword1", "badword2", "badword3");

    @Subscribe
    public void onChat(PlayerChatEvent event) {
        String message = event.getMessage();

        for (String word : blockedWords) {
            if (message.toLowerCase().contains(word.toLowerCase())) {
                event.setResult(PlayerChatEvent.ChatResult.denied());
                event.getPlayer().sendMessage(Component.text("This message contains blocked content and cannot be sent."));
                logger.info("Blocked message: " + message);
                return;
            }
        }
    }
}