package com.example.cicknimev2.animemovie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.example.cicknimev2.AnimeModel;
import com.example.cicknimev2.R;

import java.util.ArrayList;

public class AnimeMovieDatabase {
    private final Context context;

    public AnimeMovieDatabase(Context context) {
        this.context = context;
    }

    public ArrayList<AnimeModel> getListData() {
        ArrayList<AnimeModel> animeList = new ArrayList<>();

        String[] title = context.getResources().getStringArray(R.array.movie_title);
        String[] synopsis = context.getResources().getStringArray(R.array.movie_synopsis);
        String[] studios = context.getResources().getStringArray(R.array.movie_studios);
        String[] aired = context.getResources().getStringArray(R.array.movie_aired);
        String[] duration = context.getResources().getStringArray(R.array.movie_duration);
        String[] genres = context.getResources().getStringArray(R.array.movie_genres);
        String[] rating = context.getResources().getStringArray(R.array.movie_rating);
        String[] score = context.getResources().getStringArray(R.array.movie_score);

        @SuppressLint("Recycle")
        TypedArray poster = context.getResources().obtainTypedArray(R.array.movie_poster);

        for (int i = 0; i < title.length; i++) {
            AnimeModel anime = new AnimeModel();

            anime.setTitle(title[i]);
            anime.setSynopsis(synopsis[i]);
            anime.setStudios(studios[i]);
            anime.setAired(aired[i]);
            anime.setDuration(duration[i]);
            anime.setGenres(genres[i]);
            anime.setRating(rating[i]);
            anime.setPoster(poster.getResourceId(i, -1));
            anime.setScore(Float.parseFloat(score[i]));

            animeList.add(anime);
        }

        return animeList;
    }
}
