package io.github.diamondminer88;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

public class Main extends JavaPlugin implements Listener {
    FileConfiguration config;

    private void sendUpdate(String username, String action) {
        String channel = config.getString("channelid");
        String url = config.getString("url");

        if (channel.equals("") || url.equals("")) return;

        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("action", action);
        json.put("channel", "773679118524481576");

        try {
            CloseableHttpClient httpClient = HttpClients.custom().build();

            HttpPost request = new HttpPost("http://192.168.1.20:4000/mclog");
            StringEntity params = new StringEntity(json.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
            httpClient.close();
        } catch (Exception ex) {
            Bukkit.getLogger().severe("Error sending player left/join update:\n" + ex);
        }
    }

    @Override
    public void onEnable() {
        config = getConfig();
        config.addDefault("channelid", "");
        config.addDefault("url", "");
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        sendUpdate(e.getPlayer().getName(), "joined");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        sendUpdate(e.getPlayer().getName(), "left");
    }
}
