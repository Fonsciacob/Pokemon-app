package com.example.pokeapp.models.abilities;

import com.example.pokeapp.models.Sprites;
import com.example.pokeapp.models.Type;
import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {

    private String id;
    private String base_experience;
    private List<Ability> abilities;
    private List<Stat> stats;
    private String name;
    private Sprites sprites;
    private Value evolution_chain;
    private List<Type> types;

    public Abilities(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Value getEvolution_chain() {
        return evolution_chain;
    }

    public void setEvolution_chain(Value evolution_chain) {
        this.evolution_chain = evolution_chain;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "id='" + id + '\'' +
                ", base_experience='" + base_experience + '\'' +
                ", abilities=" + abilities +
                ", stats=" + stats +
                ", name='" + name + '\'' +
                ", sprites=" + sprites +
                ", evolution_chain=" + evolution_chain +
                ", types=" + types +
                '}';
    }
}
