package com.example.helloworld.api;

import com.example.helloworld.models.Student;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentApi {

    @GET("students")
    Call<Student> getAllStudent();
}
