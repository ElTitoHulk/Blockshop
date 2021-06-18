package dev.rena.proyects.utils;

import lombok.Getter;
import org.bukkit.ChatColor;

/**
 * @author devRenx
 * @version 1.0.o
 * @since 17-06-2021
 */
public class StringUtils {
    @Getter
    public static String normalLine = StringUtils.translate("&7&m-----------------------");

    public static String translate(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
