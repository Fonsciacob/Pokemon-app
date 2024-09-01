package com.example.pokeapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {

    private Value type;

    public Type() {
    }

    public Value getType() {
        return type;
    }

    public void setType(Value type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type=" + type +
                '}';
    }
}
