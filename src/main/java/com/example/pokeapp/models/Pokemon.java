package com.example.pokeapp.models;

import com.example.pokeapp.models.abilities.Abilities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon extends Abilities {

    private String next;
    private String previous;
    private List<Value> results;

    public Pokemon() {
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Value> getResults() {
        return results;
    }

    public void setResults(List<Value> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}