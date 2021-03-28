package com.gabez.smartcity_sightseeing_project.monument_details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabez.smartcity_sightseeing_project.Monument;
import com.gabez.smartcity_sightseeing_project.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MonumentDetailsFragment extends Fragment {

    private static final String ARG_MONUMENT = "ARG_MONUMENT";
    private Monument _monument;

    ImageView monumentImage;
    TextView monumentName;
    TextView monumentShortDesc;
    TextView monumentDesc;
    ExtendedFloatingActionButton monumentFavBtn;
    ExtendedFloatingActionButton monumentSeenBtn;

    public static MonumentDetailsFragment newInstance(Monument monument) {
        MonumentDetailsFragment fragment = new MonumentDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MONUMENT, monument);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            _monument = (Monument) getArguments().getParcelable(ARG_MONUMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monument_details, container, false);

        monumentImage = view.findViewById(R.id.monumentImage);
        monumentName = view.findViewById(R.id.monumentName);
        monumentShortDesc = view.findViewById(R.id.monumentShortDesc);
        monumentDesc = view.findViewById(R.id.monumentDesc);
        monumentFavBtn = view.findViewById(R.id.monumentFavBtn);
        monumentSeenBtn = view.findViewById(R.id.monumentSeenBtn);

        return view;
    }
}