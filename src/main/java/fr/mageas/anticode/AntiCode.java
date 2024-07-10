package fr.mageas.anticode;

import fr.mageas.anticode.listeners.PlayerLoginListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCode extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
    }

    @Override
    public void onDisable() {
    }

    public static AntiCode getInstance() {
        return getPlugin(AntiCode.class);
    }
}
