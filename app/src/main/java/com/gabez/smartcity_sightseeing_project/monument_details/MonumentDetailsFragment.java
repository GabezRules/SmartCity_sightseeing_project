package com.gabez.smartcity_sightseeing_project.monument_details;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.gabez.smartcity_sightseeing_project.Monument;
import com.gabez.smartcity_sightseeing_project.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.Objects;

public class MonumentDetailsFragment extends BottomSheetDialogFragment {

    private static final String ARG_MONUMENT = "ARG_MONUMENT";
    private Monument _monument;
    private MonumentDetailsViewModel viewModel = new MonumentDetailsViewModel();

    ImageView monumentImage;
    TextView monumentName;
    TextView monumentShortDesc;
    TextView monumentDesc;
    ExtendedFloatingActionButton monumentFavBtn;
    ExtendedFloatingActionButton monumentSeenBtn;
    ProgressBar progressBar;

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
            viewModel.set_monument(_monument);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monument_details, container, false);
        initViews(view);
        setImage();
        resetMonumentData();

        return view;
    }

    public void initViews(View view){
        monumentImage = view.findViewById(R.id.monumentImage);
        monumentName = view.findViewById(R.id.monumentName);
        monumentShortDesc = view.findViewById(R.id.monumentShortDesc);
        monumentDesc = view.findViewById(R.id.monumentDesc);
        monumentFavBtn = view.findViewById(R.id.monumentFavBtn);
        monumentSeenBtn = view.findViewById(R.id.monumentSeenBtn);
        progressBar = view.findViewById(R.id.progressBar);
    }

    public void setImage(){
        Glide
                .with(Objects.requireNonNull(this.getContext()))
                .load(viewModel.get_monument().get_imageUrl())
                .centerCrop()
                .dontAnimate()
                .error(R.drawable.ic_seen_outlined)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(monumentImage);
    }

    public void resetMonumentData(){
        Monument monument = viewModel.get_monument();
        monumentName.setText(monument.get_name());
        monumentShortDesc.setText(monument.get_shortDescription());
        monumentDesc.setText(monument.get_content());
        monumentFavBtn.setText(String.valueOf(monument.get_favouriteCount()));
        monumentSeenBtn.setText(String.valueOf(monument.get_seenBy()));
    }

}