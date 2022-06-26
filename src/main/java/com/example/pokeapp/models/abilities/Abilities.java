package com.example.pokeapp.models.abilities;

import com.example.pokeapp.models.Sprites;
import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {

    private String base_experience;
    private List<Ability> abilities;
    private List<Stat> stats;
    private String name;
    private Sprites sprites;

    public Abilities(){}

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "base_experience='" + base_experience + '\'' +
                ", abilities=" + abilities +
                ", stats=" + stats +
                ", name='" + name + '\'' +
                ", sprites='" + sprites + '\'' +
                '}';
    }
}
