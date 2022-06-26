package com.example.pokeapp.models;

import com.example.pokeapp.models.abilities.DreamWorld;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgDreamWorld {

    private DreamWorld dream_world;

    public ImgDreamWorld(){}

    public DreamWorld getDream_world() {
        return dream_world;
    }

    public void setDream_world(DreamWorld dream_world) {
        this.dream_world = dream_world;
    }

    @Override
    public String toString() {
        return "ImgDreamWorld{" +
                "dream_world=" + dream_world +
                '}';
    }
}
