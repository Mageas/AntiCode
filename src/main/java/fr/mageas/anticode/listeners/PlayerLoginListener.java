package fr.mageas.anticode.listeners;

import fr.mageas.anticode.config.ConfigKeys;
import fr.mageas.anticode.config.ConfigManager;
import fr.mageas.anticode.kopilote.Client;
import fr.mageas.anticode.kopilote.responses.CodeHistoryResponse;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import java.util.Objects;

public class PlayerLoginListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!Objects.equals(player.getUniqueId().toString(), ConfigManager.getString(ConfigKeys.MINECRAFT_UUID))) {
            return;
        }

        try {
            Client client = new Client(ConfigManager.getString(ConfigKeys.KOPILOT_UERNAME), ConfigManager.getString(ConfigKeys.KOPILOT_PASSWORD));
            List<CodeHistoryResponse> history =  client.retrieveCodeSessions();

            long count = history.stream().filter(item -> item.getScore() >= ConfigManager.getInt(ConfigKeys.CODE_RESULT)).count();

            if (count < ConfigManager.getInt(ConfigKeys.CODE_NUMBER)) {
                player.kickPlayer("Il faut faire son code ! (" + ConfigManager.getInt(ConfigKeys.CODE_NUMBER) + " séances de " + ConfigManager.getInt(ConfigKeys.CODE_RESULT) + " points minimum)");
            }

        } catch (Exception e) {
            Bukkit.getServer().getConsoleSender().sendMessage(e.getMessage());
        }
    }

}
