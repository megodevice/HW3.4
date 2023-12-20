package com.geeks.hw34;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geeks.hw34.databinding.FragmentContinentsBinding;

import java.util.ArrayList;

public class ContinentsFragment extends Fragment implements onItemClick {

    private FragmentContinentsBinding binding;
    private ArrayList<Continent> continents = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (continents.size() == 0) {
            binding.rvContinents.setAdapter(new ContinentsAdapter(loadData(continents), this));
        }
        else {
            binding.rvContinents.setAdapter(new ContinentsAdapter(continents, this));
        }
    }

    private ArrayList<Continent> loadData(ArrayList<Continent> continents) {
        ArrayList<String> euroAsiaCountries = new ArrayList<>();
        euroAsiaCountries.add("Россия");
        euroAsiaCountries.add("Индия");
        euroAsiaCountries.add("Германия");
        euroAsiaCountries.add("Пакистан");
        euroAsiaCountries.add("Малайзия");
        ArrayList<String> northAmericaCountries = new ArrayList<>();
        northAmericaCountries.add("Канада");
        northAmericaCountries.add("США");
        northAmericaCountries.add("Мексика");
        northAmericaCountries.add("Никарагуа");
        northAmericaCountries.add("Гондурас");
        ArrayList<String> southAmericaCountries = new ArrayList<>();
        southAmericaCountries.add("Бразилия");
        southAmericaCountries.add("Аргентина");
        southAmericaCountries.add("Перу");
        southAmericaCountries.add("Колумбия");
        southAmericaCountries.add("Боливия");
        ArrayList<String> africaCountries = new ArrayList<>();
        africaCountries.add("Алжир");
        africaCountries.add("Конго");
        africaCountries.add("Судан");
        africaCountries.add("Ливия");
        africaCountries.add("Чад");
        ArrayList<String> australiaCountries = new ArrayList<>();
        australiaCountries.add("Австралия");
        australiaCountries.add("Папуа - Новая Гвинея");
        australiaCountries.add("Новая Зеландия");
        australiaCountries.add("Соломоновы Острова");
        australiaCountries.add("Фиджи");
        continents.add(new Continent("Евразия", euroAsiaCountries, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Eurasia_%28orthographic_projection%29.svg/200px-Eurasia_%28orthographic_projection%29.svg.png"));
        continents.add(new Continent("Северная Америка", northAmericaCountries, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/200px-Location_North_America.svg.png"));
        continents.add(new Continent("Южная Америка", southAmericaCountries, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/200px-South_America_%28orthographic_projection%29.svg.png"));
        continents.add(new Continent("Африка", africaCountries, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/200px-Africa_%28orthographic_projection%29.svg.png"));
        continents.add(new Continent("Австралия", australiaCountries, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Australia_%28orthographic_projection%29.svg/200px-Australia_%28orthographic_projection%29.svg.png"));
        return continents;
    }

    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.KEY_CONTINENT, continents.get(position));
        ContinentFragment continentFragment = new ContinentFragment();
        continentFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, continentFragment).addToBackStack(null).commit();
    }
}