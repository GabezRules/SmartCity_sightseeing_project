package com.gabez.smartcity_sightseeing_project;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class MonumentsListAdapter extends RecyclerView.Adapter<MonumentsListAdapter.ViewHolder> {

    private ArrayList _monuments = new ArrayList();
    private MonumentListCallback _callback;
    private Context _context;

    public MonumentsListAdapter(MonumentListCallback callback, Context context) {
        _callback = callback;
        _context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monument, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Monument currentItem = (Monument) _monuments.get(position);
        holder.monumentName.setText(currentItem.get_name());
        holder.monumentShortDesc.setText(currentItem.get_shortDescription());

        holder.monumentSeenCount.setText((String.valueOf(currentItem.get_seenBy())));
        holder.monumentFavCount.setText(String.valueOf(currentItem.get_favouriteCount()));

        if (currentItem.get_seen()) {
            holder.monumentSeenIcon.setImageResource(R.drawable.ic_seen_filled);
            holder.monumentSeenContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _callback.setNotSeen(position);
                }
            });
        } else {
            holder.monumentSeenIcon.setImageResource(R.drawable.ic_seen_outlined);
            holder.monumentSeenContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _callback.setSeen(position);
                }
            });
        }

        if (currentItem.get_isFavourite()) {
            holder.monumentFavIcon.setImageResource(R.drawable.ic_fav_filled);
            holder.monumentFavContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _callback.setNotFavourite(position);
                }
            });
        } else {
            holder.monumentFavIcon.setImageResource(R.drawable.ic_fav_outlined);
            holder.monumentFavContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _callback.setFavourite(position);
                }
            });
        }

        holder.progressBar.setVisibility(View.VISIBLE);

        Glide
                .with(_context)
                .load(currentItem.get_imageUrl())
                .centerCrop()
                .circleCrop()
                .error(R.drawable.ic_seen_outlined)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.monumentImage);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _callback.showMonument(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _monuments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView monumentImage;
        TextView monumentName;
        TextView monumentShortDesc;

        LinearLayout monumentSeenContainer;
        LinearLayout monumentFavContainer;

        ImageView monumentSeenIcon;
        ImageView monumentFavIcon;

        TextView monumentSeenCount;
        TextView monumentFavCount;

        ProgressBar progressBar;

        View container;

        public ViewHolder(@NonNull View view) {
            super(view);
            monumentImage = view.findViewById(R.id.monumentImage);
            monumentName = view.findViewById(R.id.monumentName);
            monumentShortDesc = view.findViewById(R.id.monumentShortDesc);
            monumentSeenContainer = view.findViewById(R.id.monumentSeenContainer);
            monumentFavContainer = view.findViewById(R.id.monumentFavContainer);
            monumentSeenIcon = view.findViewById(R.id.monumentSeenIcon);
            monumentFavIcon = view.findViewById(R.id.monumentFavIcon);
            monumentSeenCount = view.findViewById(R.id.monumentSeenCount);
            monumentFavCount = view.findViewById(R.id.monumentFavCount);
            progressBar = view.findViewById(R.id.monumentProgressBar);
            container = view.findViewById(R.id.monumentContainer);
        }
    }

    public void setList(ArrayList<Monument> newMonuments) {
        _monuments.clear();
        _monuments.addAll(newMonuments);
        this.notifyDataSetChanged();
    }
}
