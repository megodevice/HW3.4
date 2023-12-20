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
    //private ImageView imageViewContinentImage;
    //private TextView textViewContinentName;
    //private TextView textViewCountries;

    /*
    если использовать биндинг верстка отображается не правильно.
    до вызова setText() элементы вообще не отображаются.
    после вызова отображаются. (imageView ни когда не отображается)
    при этом фон всегда дефолтный, не тот что указан как фон LinerLayout
    если раскомментировать старый способ findViewById и закоментировать биндинг всё работает четко
    первый фрагмент и главное активити на биндинге работает как положено.
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_continent, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initView();
        if (getArguments() != null) {
            if (getArguments().getSerializable(MainActivity.KEY_CONTINENT) != null) {
                if (getArguments().getSerializable(MainActivity.KEY_CONTINENT) instanceof Continent) {
                    continent = (Continent) getArguments().getSerializable(MainActivity.KEY_CONTINENT);
                    //Glide.with(imageViewContinentImage).load(continent.getContinentImageURL()).into(imageViewContinentImage);
                    Glide.with(binding.imageViewContinentImage).load(continent.getContinentImageURL()).into(binding.imageViewContinentImage);
                    //textViewContinentName.setText(continent.getContinentName());
                    binding.textViewContinentName.setText(continent.getContinentName());
                    for (String continentCountry : continent.getContinentCountries()) {
                        //textViewCountries.setText(textViewCountries.getText().toString() + "\n" + continentCountry);
                        binding.textViewCountries.setText(binding.textViewCountries.getText().toString() + "\n" + continentCountry);
                    }
                }
            }
        }
    }

    /*private void initView() {
        imageViewContinentImage = getView().findViewById(R.id.image_view_continent_image);
        textViewContinentName = getView().findViewById(R.id.text_view_continent_name);
        textViewCountries = getView().findViewById(R.id.text_view_countries);
    }*/
}