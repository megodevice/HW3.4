package com.geeks.hw34;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geeks.hw34.databinding.FragmentContinentBinding;

public class ContinentFragment extends Fragment {
    private FragmentContinentBinding binding;
    private Continent continent;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getSerializable(MainActivity.KEY_CONTINENT) != null) {
                if (getArguments().getSerializable(MainActivity.KEY_CONTINENT) instanceof Continent) {
                    continent = (Continent) getArguments().getSerializable(MainActivity.KEY_CONTINENT);
                    Glide.with(binding.imageViewContinentImage).load(continent.getContinentImageURL()).into(binding.imageViewContinentImage);
                    binding.textViewContinentName.setText(continent.getContinentName());
                    for (String continentCountry : continent.getContinentCountries()) {
                        binding.textViewCountries.setText(binding.textViewCountries.getText().toString() + "\n" + continentCountry);
                    }
                }
            }
        }
    }
}