package com.example.pokeapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprites {

    private String front_default;

    private String front_shiny;

    private ImgDreamWorld other;

    public Sprites(){}

    public String getFront_default() {
        return front_default;
    }

    public void setFront_shiny(String front_shiny) {
        this.front_shiny = front_shiny;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public ImgDreamWorld getOther() {
        return other;
    }

    public void setOther(ImgDreamWorld other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Sprites{" +
                "front_default='" + front_default + '\'' +
                ", front_shiny='"+front_shiny+'\'' +
                ", other=" + other +
                '}';
    }
}
