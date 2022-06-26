package com.example.pokeapp.models.species;

import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {

    private Value species;
    private List<Evolves> evolves_to;

    public Species(){};

    public Value getSpecies() {
        return species;
    }

    public void setSpecies(Value species) {
        this.species = species;
    }

    public List<Evolves> getEvolves_to() {
        return evolves_to;
    }

    public void setEvolves_to(List<Evolves> evolves_to) {
        this.evolves_to = evolves_to;
    }

    @Override
    public String toString() {
        return "Species{" +
                "species=" + species +
                ", evolves_to=" + evolves_to +
                '}';
    }
}
