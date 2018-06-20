package com.frozenorb.qlib.misc;

import com.frozenorb.commonlibs.utils.MessageUtility;

public class SimpleEntry {

    /* Prefix and Suffix for the entry */
    private String prefix, middle, suffix;

    /**
     * Simple Entry Class
     *
     * @param line - Raw line that is to be translated.
     */
    public SimpleEntry(String line){
        process(line);
    }

    /**
     * Processes the Line to fit within both a Tablst Entry and also a Scoreboard Entry
     *
     * @param line - Raw line that is to be translated.
     */
    private void process(String line) {
        String text = line;
        /* Just makes sure that the entry is below or equal to 32 character */
        if (line.length() > 32) {
            text = line.substring(0, 32);
        }
        /* If text is short enough to fit in the prefix */
        if (text.length() <= 16) {
            this.prefix = text;
            this.middle = "";
            this.suffix = "";
            return;
        }
        /* If both the prefix and suffix is needed */
        String prefix = text.substring(0, 16);
        String suffix = text.substring(16, text.length());
        if (suffix.length() > 16) {
            this.suffix = suffix.substring(16, suffix.length());
        } else {
            this.suffix = suffix;
        }
        this.prefix = prefix;
        if (prefix.endsWith("§") || prefix.endsWith("&")) {
            this.prefix = prefix.substring(0, 13);
            this.suffix = suffix.substring(1, suffix.length());
            this.middle = text.substring(13, 17);
        }
    }

    /**
     * Left part of the string
     */
    public String getPrefix() {
        return MessageUtility.formatMessage(prefix);
    }

    /**
     * Middle part of the string
     */
    public String getMiddle() {
        return MessageUtility.formatMessage(middle == null ? "" : middle);
    }

    /**
     * Right part of the string
     */
    public String getSuffix() {
        return MessageUtility.formatMessage(suffix);
    }

}
