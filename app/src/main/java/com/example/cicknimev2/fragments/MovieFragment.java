package com.example.cicknimev2.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cicknimev2.AnimeModel;
import com.example.cicknimev2.OnItemClickListener;
import com.example.cicknimev2.R;
import com.example.cicknimev2.activities.AnimeDetailActivity;
import com.example.cicknimev2.adapters.AnimeMovieAdapter;
import com.example.cicknimev2.databases.AnimeMovieDatabase;

public class MovieFragment extends Fragment implements OnItemClickListener<AnimeModel> {
    private RecyclerView rvAnimeMovie;
    private AnimeMovieDatabase animeMovieDb;
    private AnimeMovieAdapter animeMovieAdapter;

    public static MovieFragment newInstance() {
        MovieFragment movieFragment = new MovieFragment();
        Bundle args = new Bundle();

        movieFragment.setArguments(args);

        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvAnimeMovie = view.findViewById(R.id.rv_anime_movie);
        animeMovieDb = new AnimeMovieDatabase(getActivity());
        animeMovieAdapter = new AnimeMovieAdapter();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        animeMovieAdapter.setClickListener(this);
        animeMovieAdapter.setAnimes(animeMovieDb.getListData());

        rvAnimeMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvAnimeMovie.setAdapter(animeMovieAdapter);
        rvAnimeMovie.setHasFixedSize(true);
    }

    @Override
    public void onClick(AnimeModel animeModel) {
        Intent detailActivity = new Intent(getActivity(), AnimeDetailActivity.class);

        detailActivity.putExtra("ANIME_DETAIL", (Parcelable) animeModel);
        detailActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(detailActivity);
    }
}