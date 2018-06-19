package com.frozenorb.commonlibs.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MessageUtility {

    /**
     * Translates the '&' character into its respective colour code.
     *
     * @param message - The original string to be converted.
     * @return string - Translated with Colour Codes
     */
    public static String formatMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> formatMessages(List<String> messages) {
        List<String> buffered = new ArrayList<>();
        for (String message : messages){
            buffered.add(formatMessage("&r" + message));
        }
        return buffered;
    }

    /**
     * Capitalizes the First Letter of any String.
     *
     * @param original - This is the original non-capitalised string.
     * @return result - Will return the String instead with the first letter capitalised.
     */
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

}
