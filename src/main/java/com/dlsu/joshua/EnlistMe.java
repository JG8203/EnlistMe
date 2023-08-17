package com.dlsu.joshua;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;

public final class EnlistMe extends JavaPlugin {
    private UserSessionManager userSessions;
    private Map<String, CommandHandler> commandHandlers = new HashMap<>();
    private EnlistMeService enlistMeService;

    @Override
    public void onEnable() {
        // Log to console
        System.out.println("EnlistMe Plugin enabled.");

        // Initialize the EnlistMeService for Retrofit API calls
        enlistMeService = new EnlistMeService();

        // Initialize the UserSessionManager for user sessions
        userSessions = new UserSessionManager();

        // Set up command handlers
        commandHandlers.put("login", new LoginCommandHandler(userSessions));
        commandHandlers.put("listcourses", new ListCoursesCommandHandler(enlistMeService, userSessions));

        // Register commands with Spigot
        this.getCommand("login").setExecutor(new CommandExecutorAdapter(commandHandlers.get("login")));
        this.getCommand("listcourses").setExecutor(new CommandExecutorAdapter(commandHandlers.get("listcourses")));
    }

    @Override
    public void onDisable() {
        // Log to console
        System.out.println("EnlistMe Plugin disabled.");
    }
}
