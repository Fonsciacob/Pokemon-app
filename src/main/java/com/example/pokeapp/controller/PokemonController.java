package com.example.pokeapp.controller;

import com.example.pokeapp.models.Pokemon;
import com.example.pokeapp.models.abilities.Abilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class PokemonController {

    @GetMapping("/pokemon")
    public String getAllPokemon(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        Pokemon poke = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species", Pokemon.class);

        model.addAttribute("pokemons", poke.getResults());

        return "inicio";
    }

    @GetMapping("/pokemon/details")
    public String getDetailPokemon(@RequestParam(name = "search", required = true) String search, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        Abilities abilities = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + search + "", Abilities.class);

        model.addAttribute("pokemon",abilities.getName());
        model.addAttribute("img",abilities.getSprites().getOther());
        model.addAttribute("stats", abilities.getStats());
        model.addAttribute("abilities", abilities.getAbilities());

        return "details";
    }
}
