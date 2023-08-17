package com.dlsu.joshua;

import org.bukkit.entity.Player;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class ListCoursesCommandHandler implements CommandHandler {
    private EnlistMeService enlistMeService;

    private UserSessionManager userSessions;

    public ListCoursesCommandHandler(EnlistMeService enlistMeService, UserSessionManager userSessions) {
        this.enlistMeService = enlistMeService;
        this.userSessions = userSessions;  // Storing the UserSessionManager instance
    }

    @Override
    public boolean handleCommand(Player player, String[] args) {
        if (args.length != 1) {
            player.sendMessage("Please provide a COURSE_ID.");
            return false;
        }

        String courseId = args[0];
        UserSession session = userSessions.getSession(player);
        if (session == null) {
            player.sendMessage("You must be logged in to list courses.");
            return false;
        }
        String userId = session.getIdNumber();

        Call<List<CourseOffering>> call = enlistMeService.getApi().listClasses(courseId, userId);
        call.enqueue(new Callback<List<CourseOffering>>() {
            @Override
            public void onResponse(Call<List<CourseOffering>> call, Response<List<CourseOffering>> response) {
                player.sendMessage("Fetching courses, might take 60 seconds.");
                if (response.isSuccessful() && response.body() != null) {
                    List<CourseOffering> offerings = response.body();
                    for (CourseOffering offering : offerings) {
                        player.sendMessage(offering.getSubjectCode() + offering.getCatalogNbr() + ": " + offering.getSection());
                    }
                } else {
                    player.sendMessage("Error fetching courses. Please try again later.");
                }
            }

            @Override
            public void onFailure(Call<List<CourseOffering>> call, Throwable t) {
                player.sendMessage("Error fetching courses. Please try again later.");
            }
        });
        return true;
    }
}
