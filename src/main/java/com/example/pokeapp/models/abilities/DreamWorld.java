package com.example.pokeapp.models.abilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DreamWorld {

    private String front_default;

    public DreamWorld() {
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    @Override
    public String toString() {
        return "ImgDreamWorld{" +
                "front_default='" + front_default + '\'' +
                '}';
    }
}
