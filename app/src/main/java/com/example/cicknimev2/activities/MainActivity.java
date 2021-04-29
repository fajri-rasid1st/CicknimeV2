package com.example.cicknimev2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cicknimev2.R;
import com.example.cicknimev2.fragments.LibraryFragment;
import com.example.cicknimev2.fragments.MovieFragment;
import com.example.cicknimev2.fragments.TvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Toolbar tbMain;
    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMain = findViewById(R.id.tb_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        setSupportActionBar(tbMain);
        tbMain.setTitleTextAppearance(this, R.style.PoppinsSemiBoldTextAppearance);

        fragmentMap.put(R.id.menu_item_movie, MovieFragment.newInstance());
        fragmentMap.put(R.id.menu_item_tv, TvFragment.newInstance());
        fragmentMap.put(R.id.menu_item_library, LibraryFragment.newInstance());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_movie);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = fragmentMap.get(id);

        assert getSupportActionBar() != null;
        if (id == R.id.menu_item_movie) {
            getSupportActionBar().setTitle("Movie");
        } else if (id == R.id.menu_item_tv) {
            getSupportActionBar().setTitle("TV");
        } else {
            getSupportActionBar().setTitle("Library");
        }

        assert fragment != null;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();

        return true;
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
}