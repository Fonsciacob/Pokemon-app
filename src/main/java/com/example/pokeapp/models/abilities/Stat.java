package com.example.pokeapp.models.abilities;

import com.example.pokeapp.models.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {

    private String base_stat;
    private Value stat;

    public Stat() {
    }

    public String getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(String base_stat) {
        this.base_stat = base_stat;
    }

    public Value getStat() {
        return stat;
    }

    public void setStat(Value stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "base_stat='" + base_stat + '\'' +
                ", stat=" + stat +
                '}';
    }
}
