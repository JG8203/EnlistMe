package com.dlsu.joshua;

import org.bukkit.entity.Player;

public interface CommandHandler {
    boolean handleCommand(Player player, String[] args);
}
