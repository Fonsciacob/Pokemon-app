package com.example.pokeapp.models.abilities;

import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {

    private Value ability;

    public Value getAbility() {
        return ability;
    }

    public void setAbility(Value ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "ability=" + ability +
                '}';
    }
}
