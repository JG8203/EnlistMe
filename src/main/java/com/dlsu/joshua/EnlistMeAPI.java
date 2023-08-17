package com.dlsu.joshua;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface EnlistMeAPI {
    @POST("login")
    Call<Void> loginUser(@Query("id") String idNumber);

    @FormUrlEncoded
    @POST("/listclasses/{course_id}")
    Call<List<CourseOffering>> listClasses(@Path("course_id") String courseId, @Field("user_id") String userId);

}
