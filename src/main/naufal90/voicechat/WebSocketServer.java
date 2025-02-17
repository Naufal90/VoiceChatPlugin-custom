package main.naufal90.voicechatplugin;

import org.java-websocket.server.WebSocketServer;
import org.java-websocket.WebSocket;
import org.java-websocket.handshake.ClientHandshake;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebSocketServer extends WebSocketServer {

    public WebSocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // Handle new connections
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        // Handle closing connections
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        // Handle incoming messages
        // Implement mute/unmute, proximity voice, etc. commands based on the message
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("WebSocket server started successfully");
    }
}
