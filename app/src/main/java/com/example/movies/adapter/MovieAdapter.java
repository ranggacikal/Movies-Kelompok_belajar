package com.example.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies.R;
import com.example.movies.model.ResultsItem;
import com.example.movies.util.Constants;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<ResultsItem> movieItems;

    public MovieAdapter(Context context, List<ResultsItem> movieItems) {
        this.context = context;
        this.movieItems = movieItems;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movies, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.txtTitleMovie.setText(movieItems.get(position).getTitle());

        String url_image = Constants.URL_IMAGE+movieItems.get(position).getPosterPath();
        Glide.with(context)
                .load(url_image)
                .into(holder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return movieItems.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMovie;
        TextView txtTitleMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.iv_movies);
            txtTitleMovie = itemView.findViewById(R.id.tv_title_movie);
        }
    }
}
