package com.example.movies.api;

import com.example.movies.model.ResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie/now_playing")
    Call<ResponseMovies> getMovies(@Query("api_key") String apiKey,
                                   @Query("language") String language,
                                   @Query("page") String page,
                                   @Query("region") String region);

}
