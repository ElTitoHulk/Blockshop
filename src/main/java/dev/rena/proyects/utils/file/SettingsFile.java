package dev.rena.proyects.utils.file;

import dev.rena.proyects.BlockShop;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class SettingsFile extends YamlConfiguration {
        private static SettingsFile config;
        private final Plugin plugin;
        private final File configFile;

        public static SettingsFile getConfig() {
            if (SettingsFile.config == null) {
                SettingsFile.config = new SettingsFile();
            }
            return SettingsFile.config;
        }

        private Plugin main() {
            return BlockShop.getInstance();
        }

        public SettingsFile() {
            this.plugin = this.main();
            this.configFile = new File(this.plugin.getDataFolder(), "settings.yml");
            this.saveDefault();
            this.reload();
        }

        public void reload() {
            try {
                super.load(this.configFile);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void save() {
            try {
                super.save(this.configFile);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void saveDefault() {
            this.plugin.saveResource("settings.yml", false);
        }

        public void saveAll() {
            this.save();
            this.reload();
        }
}
