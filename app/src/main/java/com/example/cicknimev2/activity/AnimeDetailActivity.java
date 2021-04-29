package com.example.cicknimev2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cicknimev2.AnimeModel;
import com.example.cicknimev2.R;
import com.google.android.material.button.MaterialButton;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class AnimeDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar tbDetail;
    private MaterialButton btnFavorite;
    private AnimeModel anime = null;
    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        anime = getIntent().getParcelableExtra("ANIME_DETAIL");
        tbDetail = findViewById(R.id.tb_detail);
        btnFavorite = findViewById(R.id.btn_favorite);
        btnFavorite.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        setSupportActionBar(tbDetail);
        tbDetail.setTitleTextAppearance(this, R.style.WhiteTextAppearance);
        setDetailActivityContent();

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(anime.getTitle());
    }

    @SuppressLint("SetTextI18n")
    private void setDetailActivityContent() {
        TextView tvTitle = findViewById(R.id.tv_title_detail);
        TextView tvSubtitle = findViewById(R.id.tv_subtitle_detail);
        TextView tvFullTitle = findViewById(R.id.tv_full_title_detail);
        TextView tvStudios = findViewById(R.id.tv_studio_detail);
        TextView tvAired = findViewById(R.id.tv_aired_detail);
        TextView tvGenres = findViewById(R.id.tv_genres_detail);
        ExpandableTextView etvSynopsis = findViewById(R.id.etv_synopsis_detail);
        TextView tvScore = findViewById(R.id.tv_score_detail);
        RatingBar rbScore = findViewById(R.id.rb_star_detail);
        ImageView ivPoster = findViewById(R.id.iv_poster_detail);
        ImageView ivBanner = findViewById(R.id.iv_banner_detail);

        tvTitle.setText(anime.getTitle());
        tvSubtitle.setText(anime.getGenres().split(", ")[0] + " • " + anime.getDuration() + " • " + anime.getRating());
        tvFullTitle.setText(anime.getTitle());
        tvStudios.setText(anime.getStudios());
        tvAired.setText(anime.getAired());
        tvGenres.setText(anime.getGenres());
        etvSynopsis.setText(anime.getSynopsis());
        tvScore.setText(String.valueOf(anime.getScore()));
        rbScore.setRating(anime.getScore() / 2);
        ivPoster.setImageResource(anime.getPoster());
        ivBanner.setImageResource(anime.getPoster());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_favorite) btnFavoriteHandler();
    }

    private void btnFavoriteHandler() {
        if (!isFavorite) {
            btnFavorite.setIconResource(R.drawable.ic_baseline_favorite_24);
            Toast.makeText(this, "Anime has been added to favorite", Toast.LENGTH_SHORT).show();
        } else {
            btnFavorite.setIconResource(R.drawable.ic_baseline_favorite_border_24);
            Toast.makeText(this, "Anime has been removed from favorite", Toast.LENGTH_SHORT).show();
        }

        isFavorite = !isFavorite;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        for (int i = 0; i < menu.size(); i++) {
            Drawable drawable = menu.getItem(i).getIcon();

            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources()
                        .getColor(R.color.textOnPrimary), PorterDuff.Mode.SRC_ATOP);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return true;
    }
}