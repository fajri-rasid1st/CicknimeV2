package com.example.cicknimev2.adapters;

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

public class AnimeTvAdapter extends RecyclerView.Adapter<AnimeTvAdapter.ListViewHolder> {
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
    public AnimeTvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_anime_tv, parent, false);
        return new AnimeTvAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeTvAdapter.ListViewHolder holder, int position) {
        holder.onBind(animes.get(position));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AnimeModel anime;
        TextView tvTitle, tvSynopsis;
        ImageView ivPoster;
        RatingBar rbStarScore;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tvTitle = itemView.findViewById(R.id.tv_title_list);
            tvSynopsis = itemView.findViewById(R.id.tv_synopsis_list);
            ivPoster = itemView.findViewById(R.id.iv_poster_list);
            rbStarScore = itemView.findViewById(R.id.rb_score_list);
        }

        public void onBind(AnimeModel anime) {
            this.anime = anime;

            tvTitle.setText(anime.getTitle());
            tvSynopsis.setText(anime.getSynopsis());
            ivPoster.setImageResource(anime.getPoster());
            rbStarScore.setRating(anime.getScore() / 2);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(anime);
        }
    }
}
