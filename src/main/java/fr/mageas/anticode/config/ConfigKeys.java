package fr.mageas.anticode.config;

public enum ConfigKeys {
    KOPILOT_UERNAME("kopilot.username"),
    KOPILOT_PASSWORD("kopilot.password"),
    MINECRAFT_UUID("minecraft.uuid"),
    CODE_NUMBER("code.number"),
    CODE_RESULT("code.result");

    private final String path;

    ConfigKeys(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
