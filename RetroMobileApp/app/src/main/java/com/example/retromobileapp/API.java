package com.example.retromobileapp;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
     @GET("/users")
     Call<JsonObject> getAllUsers();

     @POST ("/users")
    Call<JsonObject> insertUsers(@Body User user);

     @GET("/users/{id}")
     Call<JsonObject> getUserById( @Path("id") int id);






}
