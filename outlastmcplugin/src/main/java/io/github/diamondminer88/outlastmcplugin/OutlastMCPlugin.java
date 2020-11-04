package io.github.diamondminer88.outlastmcplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Hashtable;

public class OutlastMCPlugin extends JavaPlugin implements CommandExecutor, Listener {
//    private Hashtable<Player, Integer> seconds_left_in_combat = new Hashtable<>();

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        this.getCommand("respawn").setExecutor(this);
        this.getCommand("discord").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);

        if (this.getConfig().getBoolean("discord_invite_enabled")) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("discord_invite"))), 10 * 20, this.getConfig().getInt("discord_interval_in_seconds") * 20);
        }
        if (this.getConfig().getBoolean("reddragon_message_enabled")) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("reddragon_message"))), 20 * 20, this.getConfig().getInt("reddragon_message_interval_in_seconds") * 20);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equals("respawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("§8Sending you to spawn...");
                player.teleport(new Location(player.getWorld(), this.getConfig().getInt("spawn_x"), this.getConfig().getInt("spawn_y"), this.getConfig().getInt("spawn_z")));
                player.getLocation().setYaw(this.getConfig().getInt("spawn_yaw"));
                player.getLocation().setPitch(this.getConfig().getInt("spawn_pitch"));
                return true;
            }
            sender.sendMessage("§cOnly Players can execute this command");
            return true;
        } else if (label.equals("discord") && this.getConfig().getBoolean("discord_invite_enabled")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("discord_invite")));
        }
        return true;
    }

//    @EventHandler
//    public void onPlayerLogin(PlayerLoginEvent event) {
//        seconds_left_in_combat.put(event.getPlayer(), 0);
//    }
//
//    @EventHandler
//    public void onPlayerDisconnect(PlayerQuitEvent event) {
//        if (seconds_left_in_combat.get(event.getPlayer()) > 0) {
//            Bukkit.broadcastMessage("§c"+event.getPlayer().getDisplayName()+" §rdisconnected while in combat");
//        }
//    }
//
//    @EventHandler
//    public void onPlayerDeath(PlayerDeathEvent event) {
//        seconds_left_in_combat.put(event.getEntity(), 0);
//    }
//
//    @EventHandler
//    public void playerHitPlayerEvent(EntityDamageByEntityEvent event) {
//        Entity attacker = event.getDamager();
//        Entity victim = event.getEntity();
//        if (attacker instanceof Player) {
//            Player player = (Player) attacker;
//            int starting_secs = seconds_left_in_combat.get(player);
//            seconds_left_in_combat.put(player, 13);
//            if (starting_secs == 0) {
//                BukkitRunnable task = new BukkitRunnable() {
//                    @Override
//                    public void run() {
//                        int secs = seconds_left_in_combat.get(player);
//                        if (secs > 0) {
//                            seconds_left_in_combat.put(player, secs-1);
//                        }
//                        else {
//                            this.cancel();
//                        }
//                    }
//                };
//                task.runTaskTimer(this, 20, 20);
//            }
//        }
//        if (victim instanceof Player) {
//            Player player = (Player) victim;
//            int starting_secs = seconds_left_in_combat.get(player);
//            seconds_left_in_combat.put(player, 13);
//            if (starting_secs == 0) {
//                BukkitRunnable task = new BukkitRunnable() {
//                    @Override
//                    public void run() {
//                        int secs = seconds_left_in_combat.get(player);
//                        if (secs > 0) {
//                            seconds_left_in_combat.put(player, secs-1);
//                        }
//                        else {
//                            this.cancel();
//                        }
//                    }
//                };
//                task.runTaskTimer(this, 20, 20);
//            }
//        }
//    }
}
