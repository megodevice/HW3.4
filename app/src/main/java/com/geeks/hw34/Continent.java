package com.geeks.hw34;

import java.io.Serializable;
import java.util.ArrayList;

public class Continent implements Serializable {
    private String continentName;
    private ArrayList<String> continentCountries;
    private String continentImageURL;

    public String getContinentName() {
        return continentName;
    }

    public ArrayList<String> getContinentCountries() {
        return continentCountries;
    }

    public String getContinentImageURL() {
        return continentImageURL;
    }

    public Continent(String continentName, ArrayList<String> continentCities, String continentImageURL) {
        this.continentName = continentName;
        this.continentCountries = continentCities;
        this.continentImageURL = continentImageURL;
    }
}
