package me.tizo.textfilter;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "textfilter",
        name = "Textfilter",
        version = "1.0.0"
)

public class Textfilter {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public Textfilter(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;

        logger.info("Hello there! I made my first plugin with Velocity.");
    }
}