package com.geeks.hw34;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geeks.hw34.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentItemViewHolder> {
    private ArrayList<Continent> continents;
    private onItemClick onContinentItemClick;
    public ContinentsAdapter(ArrayList<Continent> continents, onItemClick onContinentItemClick) {
        this.onContinentItemClick = onContinentItemClick;
        this.continents = continents;
    }

    @NonNull
    @Override
    public ContinentItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentItemViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentItemViewHolder holder, int position) {
        holder.onBind(continents.get(position));
        holder.itemView.setOnClickListener(v -> {
            onContinentItemClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }
}

class ContinentItemViewHolder extends RecyclerView.ViewHolder {
    private ItemContinentBinding binding;
    public void onBind(Continent continent) {
        binding.textViewContinentName.setText(continent.getContinentName());
        Glide.with(binding.imageViewContinentImage).load(continent.getContinentImageURL()).into(binding.imageViewContinentImage);
    }
    public ContinentItemViewHolder(@NonNull ItemContinentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}

interface onItemClick {
    void onClick(int position);
}
