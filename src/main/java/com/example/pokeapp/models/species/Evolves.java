package com.example.pokeapp.models.species;

import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evolves {

    private String is_baby;
    private Value species;
    private List<Species> evolves_to;

    public Evolves(){}

    public String getIs_baby() {
        return is_baby;
    }

    public void setIs_baby(String is_baby) {
        this.is_baby = is_baby;
    }

    public Value getSpecies() {
        return species;
    }

    public void setSpecies(Value species) {
        this.species = species;
    }

    public List<Species> getEvolves_to() {
        return evolves_to;
    }

    public void setEvolves_to(List<Species> evolves_to) {
        this.evolves_to = evolves_to;
    }

    @Override
    public String toString() {
        return "Evolves{" +
                "is_baby='" + is_baby + '\'' +
                ", species=" + species +
                ", evolves_to=" + evolves_to +
                '}';
    }
}
