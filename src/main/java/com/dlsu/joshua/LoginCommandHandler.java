package com.dlsu.joshua;

import org.bukkit.entity.Player;

public class LoginCommandHandler implements CommandHandler {
    private UserSessionManager userSessions;

    public LoginCommandHandler(UserSessionManager userSessions) {
        this.userSessions = userSessions;
    }

    @Override
    public boolean handleCommand(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage("Please provide your ID number.");
            return false;
        }

        String idNumber = args[0];
        userSessions.createSession(player, idNumber);
        player.sendMessage("Successfully logged in with ID: " + idNumber);
        return true;
    }
}
