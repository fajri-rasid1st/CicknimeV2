package com.example.cicknimev2.animemovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cicknimev2.AnimeModel;
import com.example.cicknimev2.OnItemClickListener;
import com.example.cicknimev2.R;

import java.util.ArrayList;

public class AnimeMovieAdapter extends RecyclerView.Adapter<AnimeMovieAdapter.ListViewHolder> {
    private ArrayList<AnimeModel> animes;
    private OnItemClickListener<AnimeModel> clickListener;

    public void setAnimes(ArrayList<AnimeModel> animes) {
        this.animes = animes;
    }

    public void setClickListener(OnItemClickListener<AnimeModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_anime_movie, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.onBind(animes.get(position));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AnimeModel anime;
        TextView tvTitle, tvGenre, tvScore;
        ImageView ivPoster;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tvTitle = itemView.findViewById(R.id.tv_title_movie_anime);
            tvGenre = itemView.findViewById(R.id.tv_genre_movie_anime);
            tvScore = itemView.findViewById(R.id.tv_score_movie_anime);
            ivPoster = itemView.findViewById(R.id.iv_poster_movie_anime);
        }

        public void onBind(AnimeModel anime) {
            this.anime = anime;

            tvTitle.setText(anime.getTitle());
            tvGenre.setText(anime.getGenres().split(", ")[0]);
            tvScore.setText(String.valueOf(anime.getScore()));
            ivPoster.setImageResource(anime.getPoster());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(anime);
        }
    }
}
