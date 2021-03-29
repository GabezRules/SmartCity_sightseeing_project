package com.gabez.smartcity_sightseeing_project.monument_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gabez.smartcity_sightseeing_project.Monument;
import com.gabez.smartcity_sightseeing_project.R;
import com.gabez.smartcity_sightseeing_project.monument_details.MonumentDetailsFragment;

import java.util.Objects;

public class MonumentsListFragment extends Fragment implements MonumentListCallback {

    RecyclerView monumentsList = null;

    MonumentListViewModel viewModel = new MonumentListViewModel();

    public static MonumentsListFragment newInstance() {
        return new MonumentsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monuments_list, container, false);
        monumentsList = view.findViewById(R.id.monumentsList);
        monumentsList.setAdapter(new MonumentsListAdapter((MonumentListCallback) this, this.getContext()));
        monumentsList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        refreshList();
        return view;
    }

    @Override
    public void setFavourite(int monument) {
        viewModel.setFavourite(monument);
        refreshList(monument);

    }

    @Override
    public void setNotFavourite(int monument) {
        viewModel.setNotFavourite(monument);
        refreshList(monument);
    }

    @Override
    public void setSeen(int monument) {
        viewModel.setSeen(monument);
        refreshList(monument);
    }

    @Override
    public void setNotSeen(int monument) {
        viewModel.setNotSeen(monument);
        refreshList(monument);
    }

    @Override
    public void showMonument(Monument monument) {
        MonumentDetailsFragment detailsFragment = MonumentDetailsFragment.newInstance(monument);
        assert getFragmentManager() != null;
        detailsFragment.show(getFragmentManager(), "monument_details_fragment");
    }

    void refreshList(){
        ((MonumentsListAdapter) Objects.requireNonNull(monumentsList.getAdapter())).setList(viewModel.getAllMonuments());
    }

    void refreshList(int position){
        Objects.requireNonNull(monumentsList.getAdapter()).notifyItemChanged(position);
    }
}