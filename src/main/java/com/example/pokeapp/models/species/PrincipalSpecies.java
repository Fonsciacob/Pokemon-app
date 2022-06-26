package com.example.pokeapp.models.species;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrincipalSpecies {

    private Species chain;

    public PrincipalSpecies() {
    }

    public Species getChain() {
        return chain;
    }

    public void setChain(Species chain) {
        this.chain = chain;
    }

    @Override
    public String toString() {
        return "PrincipalSpecies{" +
                "chain=" + chain +
                '}';
    }
}
