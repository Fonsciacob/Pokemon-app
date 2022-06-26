package com.example.pokeapp.models;

import com.example.pokeapp.models.abilities.DreamWorld;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgDreamWorld {

    private DreamWorld home;

    public ImgDreamWorld(){}

    public DreamWorld getHome() {
        return home;
    }

    public void setHome(DreamWorld home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "ImgDreamWorld{" +
                "home=" + home +
                '}';
    }
}
