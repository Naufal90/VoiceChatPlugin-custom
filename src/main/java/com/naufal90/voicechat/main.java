package com.naufal90.voicechatplugin;

import de.maxhenkel.voicechat.api.*;
import de.maxhenkel.voicechat.api.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public class VoiceChatPlugin extends JavaPlugin implements VoicechatPlugin {

    private VoicechatApi api;
    private WebSocketServer webSocketServer;

    @Override
    public void onEnable() {
        // Register the plugin with the Voicechat API
        VoicechatApi api = Voicechat.getApi();
        if (api != null) {
            api.registerPlugin(this);
        }

        // Load configuration
        saveDefaultConfig();
        int port = getConfig().getInt("websocket-port", 8080);

        // Start WebSocket server
        webSocketServer = new WebSocketServer(port);
        webSocketServer.start();

        // Register commands
        this.getCommand("mute").setExecutor(new MuteCommand());
        this.getCommand("unmute").setExecutor(new UnmuteCommand());
    }

    @Override
    public void onDisable() {
        // Stop WebSocket server
        if (webSocketServer != null) {
            webSocketServer.stop();
        }
    }

    @Override
    public String getPluginId() {
        return "VoiceChatPlugin";
    }

    @EventSubscription
    public void onVoiceChatConnected(VoicechatConnectedEvent event) {
        // Handle voice chat connection
    }

    @EventSubscription
    public void onVoiceChatDisconnected(VoicechatDisconnectedEvent event) {
        // Handle voice chat disconnection
    }
}
