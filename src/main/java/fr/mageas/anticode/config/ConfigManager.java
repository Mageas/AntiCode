package fr.mageas.anticode.config;

import fr.mageas.anticode.AntiCode;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigManager {
    private static final AntiCode antiCode = AntiCode.getInstance();

    public static String getString(ConfigKeys key) {
        return antiCode.getConfig().getString(key.getPath());
    }

    public static Integer getInt(ConfigKeys key) {
        return antiCode.getConfig().getInt(key.getPath());
    }


    public static List<String> getStringList(ConfigKeys key) {
        return antiCode.getConfig().getStringList(key.getPath());
    }

    public static List<Integer> getIntList(ConfigKeys key) {
        return antiCode.getConfig().getStringList(key.getPath()).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
