package me.libraryaddict.Hungergames.Configs;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MySqlConfig extends BaseConfig {

    private boolean buyKitMenuEnabled;
    private String mysql_database = "database";
    private String mysql_host = "localhost";
    private String mysql_password = "password";
    private String mysql_username = "root";
    private boolean mysqlEnabled = false;
    private boolean mysqlKitsEnabled = true;
    private String rankingFormula = "(((Wins * 5) + (Kills / 10) / (Losses / 10)) + ((Wins + Losses) / 50)) + Killstreak";
    private boolean statsEnabled;
    private boolean useUUIDs = true;

    public MySqlConfig() {
        super("mysql");
        File file = new File("plugins/LibsHungergames/config.yml");
        if (file.exists()) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            buyKitMenuEnabled = config.getBoolean("mysqlEnabled");
            statsEnabled = config.getBoolean("mysqlEnabled");
            mysqlEnabled = config.getBoolean("mysqlEnabled");
            config.set("mysqlEnabled", null);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public boolean isMysqlEnabled() {
        return mysqlEnabled && (statsEnabled || buyKitMenuEnabled || mysqlKitsEnabled);
    }
}
