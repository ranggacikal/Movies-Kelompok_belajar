package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.movies.adapter.MovieAdapter;
import com.example.movies.api.ApiConfig;
import com.example.movies.model.ResponseMovies;
import com.example.movies.model.ResultsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMovie;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovie = findViewById(R.id.rv_movies);
        rvMovie.setHasFixedSize(true);
        GridLayoutManager gridManager = new GridLayoutManager(MainActivity.this,
                2, GridLayoutManager.VERTICAL, false);
        rvMovie.setLayoutManager(gridManager);

        getMovies();

    }

    private void getMovies() {
        String apiKey = "4dc0df591f7e95ce17572b9c837d2939";
        String language = "en-US";
        String page = "1";
        String region = "ID";

        ApiConfig apiConfig = new ApiConfig();
        apiConfig.service.getMovies(apiKey, language, page, region).enqueue(new Callback<ResponseMovies>() {
            @Override
            public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                if (response.isSuccessful()){
                    ResponseMovies responseMovies = response.body();
                    List<ResultsItem> result = responseMovies.getResults();
                    adapter = new MovieAdapter(MainActivity.this, result);
                    rvMovie.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this,
                            "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovies> call, Throwable t) {
                Log.d("data-movies", t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}