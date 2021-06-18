package dev.rena.proyects;

import dev.rena.proyects.utils.StringUtils;
import dev.rena.proyects.utils.file.SettingsFile;
import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockShop extends JavaPlugin {
    @Getter
    private static SettingsFile settingsFile;
    @Getter
    public static BlockShop instance;
    @Getter
    public static Economy economy = null;

    @Override
    public void onEnable() {
        // Plugin startup logic

        settingsFile = new SettingsFile();

        instance = this;

        if(Bukkit.getPluginManager().getPlugin("Vault") == null){
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        }else{
            this.setupEconomy();
            this.getLogger().warning(StringUtils.getNormalLine());
            this.getLogger().warning( StringUtils.translate("&7This plugin depends on the VAULT extension."));
            this.getLogger().warning( StringUtils.translate("&cTHE PLUGIN IS COMPLETELY DISABLED"));
            this.getLogger().warning( StringUtils.translate("&7Get the plugin here: &ahttps://dev.bukkit.org/projects/vault"));
            this.getLogger().warning(StringUtils.getNormalLine());
        }

        this.getLogger().info( StringUtils.translate(StringUtils.getNormalLine()) );
        this.getLogger().info( StringUtils.translate("&aBlockshop - "+ getDescription().getAuthors()) );
        this.getLogger().info( StringUtils.translate("&aVersion - "+ getDescription().getVersion()) );
        this.getLogger().info( StringUtils.translate("&aContact: Deprecated#2064") );
        this.getLogger().info( StringUtils.translate(StringUtils.getNormalLine()) );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().warning("This plugin has disabled!");
    }

    private void setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
    }

}
