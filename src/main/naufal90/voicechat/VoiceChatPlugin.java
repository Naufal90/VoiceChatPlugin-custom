package main.naufal90.voicechat;

import de.maxhenkel.voicechat.api.VoiceChatManager;
import de.maxhenkel.voicechat.api.VoiceChatPlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class VoiceChatPlugin extends JavaPlugin {

    private WebSocketServer websocketServer;
    private int websocketPort;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        websocketPort = config.getInt("websocket.port", 12345);  // Default port: 12345

        // Start WebSocket server
        websocketServer = new WebSocketServer(websocketPort);
        try {
            websocketServer.start();
        } catch (IOException e) {
            getLogger().severe("Failed to start WebSocket server: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info("VoiceChat Plugin enabled and WebSocket server started on port " + websocketPort);
    }

    @Override
    public void onDisable() {
        if (websocketServer != null) {
            websocketServer.stop();
        }
        getLogger().info("VoiceChat Plugin disabled");
    }

    // Mute/Unmute command
    public void toggleMute(VoiceChatPlayer player) {
        if (player.isMuted()) {
            VoiceChatManager.getInstance().unmutePlayer(player);
        } else {
            VoiceChatManager.getInstance().mutePlayer(player);
        }
    }

    // Proximity voice logic can be added here based on the API
}
