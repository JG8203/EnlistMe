package com.dlsu.joshua;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExecutorAdapter implements CommandExecutor {
    private CommandHandler commandHandler;

    public CommandExecutorAdapter(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            return commandHandler.handleCommand((Player) sender, args);
        }
        return false;
    }
}
