package com.dlsu.joshua;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class UserSessionManager {
    private Map<String, UserSession> userSessions;

    public UserSessionManager() {
        userSessions = new HashMap<>();
    }

    public UserSession getSession(Player player) {
        return userSessions.get(player.getName());
    }

    public void createSession(Player player, String idNumber) {
        userSessions.put(player.getName(), new UserSession(idNumber));
    }

    public void removeSession(Player player) {
        userSessions.remove(player.getName());
    }
}
