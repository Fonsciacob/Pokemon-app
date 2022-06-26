package com.example.pokeapp.controller;

import com.example.pokeapp.models.Pokemon;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class pueba {

    @RequestMapping("/pokemon")
    public String getAllPokemon(Model pokemon) {

        RestTemplate restTemplate = new RestTemplate();
        Pokemon poke = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species", Pokemon.class);

        pokemon.addAttribute("pokemons",poke.getResults());

        return "inicio";
    }
}

