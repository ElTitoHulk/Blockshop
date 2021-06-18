package dev.rena.proyects.listener;

import dev.rena.proyects.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class InventoryClickListener implements Listener {

    static Inventory inventory = Bukkit.createInventory(null, 9*3, StringUtils.translate(""));

}
