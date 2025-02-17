package main.naufal90.voicechat;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.logging.Level;

public class VoiceChatPlugin extends JavaPlugin {

    private static VoiceChatPlugin instance;
    private int websocketPort;
    private boolean proximityVoice;
    private int proximityRange;
    private boolean groupVoice;
    private boolean enableLogs;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig(); // Load config.yml jika belum ada
        loadConfig();

        getLogger().info("VoiceChat Plugin telah aktif!");
        getLogger().info("WebSocket berjalan di port: " + websocketPort);
    }

    public static VoiceChatPlugin getInstance() {
        return instance;
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();
        websocketPort = config.getInt("websocket-port", 24454);
        proximityVoice = config.getBoolean("proximity-voice", true);
        proximityRange = config.getInt("proximity-range", 32);
        groupVoice = config.getBoolean("group-voice", true);
        enableLogs = config.getBoolean("enable-logs", true);

        if (enableLogs) {
            getLogger().log(Level.INFO, "Logging diaktifkan.");
        }
    }

    public int getWebsocketPort() {
        return websocketPort;
    }

    public boolean isProximityVoiceEnabled() {
        return proximityVoice;
    }

    public int getProximityRange() {
        return proximityRange;
    }

    public boolean isGroupVoiceEnabled() {
        return groupVoice;
    }

    public boolean isLoggingEnabled() {
        return enableLogs;
    }
}
