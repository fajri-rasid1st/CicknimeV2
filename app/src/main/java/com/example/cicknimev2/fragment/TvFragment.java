package com.example.cicknimev2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cicknimev2.AnimeModel;
import com.example.cicknimev2.OnItemClickListener;
import com.example.cicknimev2.R;
import com.example.cicknimev2.activity.AnimeDetailActivity;
import com.example.cicknimev2.animetv.AnimeTvAdapter;
import com.example.cicknimev2.animetv.AnimeTvDatabase;

public class TvFragment extends Fragment implements OnItemClickListener<AnimeModel> {
    private RecyclerView rvAnimeTv;
    private AnimeTvDatabase animeTvDb;
    private AnimeTvAdapter animeTvAdapter;

    public static TvFragment newInstance() {
        TvFragment tvFragment = new TvFragment();
        Bundle args = new Bundle();

        tvFragment.setArguments(args);

        return tvFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        rvAnimeTv = view.findViewById(R.id.rv_anime_tv);
        animeTvDb = new AnimeTvDatabase(getActivity());
        animeTvAdapter = new AnimeTvAdapter();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        animeTvAdapter.setClickListener(this);
        animeTvAdapter.setAnimes(animeTvDb.getListData());

        rvAnimeTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAnimeTv.setAdapter(animeTvAdapter);
        rvAnimeTv.setHasFixedSize(true);
    }

    @Override
    public void onClick(AnimeModel animeModel) {
        Intent detailActivity = new Intent(getActivity(), AnimeDetailActivity.class);

        detailActivity.putExtra("ANIME_DETAIL", (Parcelable) animeModel);
        detailActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(detailActivity);
    }
}