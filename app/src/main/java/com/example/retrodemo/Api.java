package com.example.retrodemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL="https://api.railwayapi.com/v2/route/train/22981/apikey/1hklsxpspj/";

    @GET("/")
    Call<List<RouteData>> getrouteData();
}
