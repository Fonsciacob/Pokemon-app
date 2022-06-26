package com.example.pokeapp.controller;

import com.example.pokeapp.models.Pokemon;
import com.example.pokeapp.models.Value;
import com.example.pokeapp.models.abilities.Abilities;
import com.example.pokeapp.models.species.Evolves;
import com.example.pokeapp.models.species.PrincipalSpecies;
import com.example.pokeapp.models.species.Species;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class PokemonController {

    @GetMapping("/pokemon")
    public String getAllPokemon(@RequestParam(name = "offset", required = false, defaultValue = "0") String offset, @RequestParam(name = "limit", required = false, defaultValue = "20") String limit, Model model) throws MalformedURLException {

        RestTemplate restTemplate = new RestTemplate();
        Pokemon poke = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species/?offset=" + offset + "&limit=" + limit + "", Pokemon.class);

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        for (Value value : poke.getResults()) {
            pokemons.add(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + value.getName() + "", Pokemon.class));
        }

        if (poke.getPrevious() != null) {
            URL back = new URL(poke.getPrevious());
            model.addAttribute("back", back.getQuery());
        } else {
            model.addAttribute("back", null);
        }

        URL next = new URL(poke.getNext());

        model.addAttribute("next", next.getQuery());
        model.addAttribute("pokemons", pokemons);

        return "inicio";
    }

    @GetMapping("/pokemon/detail")
    public String getDetailPokemon(@RequestParam(name = "search", required = true) String search, Model model) {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Abilities> pokemons = new ArrayList<Abilities>();

        Pokemon abilities = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + search + "", Pokemon.class);
        Pokemon urlEvolution = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species/" + search + "", Pokemon.class);

        //Consume Evolution Chains
        PrincipalSpecies species = restTemplate.getForObject(urlEvolution.getEvolution_chain().getUrl(), PrincipalSpecies.class);

        Pokemon abilitiesP = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + species.getChain().getSpecies().getName() + "", Pokemon.class);
        pokemons.add(abilitiesP);

        for (Evolves evolves : species.getChain().getEvolves_to()) {
            Pokemon abilities1 = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + evolves.getSpecies().getName() + "", Pokemon.class);
            pokemons.add(abilities1);
            for (Species specie : evolves.getEvolves_to()) {
                Pokemon abilities2 = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + specie.getSpecies().getName() + "", Pokemon.class);
                pokemons.add(abilities2);
            }
        }

        model.addAttribute("evolutions", pokemons);
        model.addAttribute("pokemon", abilities.getName());
        model.addAttribute("img", abilities.getSprites().getOther());
        model.addAttribute("stats", abilities.getStats());
        model.addAttribute("abilities", abilities.getAbilities());

        return "details";
    }
}
