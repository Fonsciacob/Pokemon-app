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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class PokemonController {

    @GetMapping("/")
    public String getAllPokemon(@RequestParam(name = "offset", required = false, defaultValue = "0") String offset, @RequestParam(name = "limit", required = false, defaultValue = "8") String limit, Model model) throws MalformedURLException {

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        Pokemon pokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species/?offset=" + offset + "&limit=" + limit + "", Pokemon.class);

        for (Value value : pokemon.getResults()) {
            pokemons.add(restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + value.getName() + "", Pokemon.class));
        }

        if (pokemon.getPrevious() != null) {
            URL back = new URL(pokemon.getPrevious());
            model.addAttribute("back", back.getQuery());
        } else {
            model.addAttribute("back", null);
        }

        URL next = new URL(pokemon.getNext());

        model.addAttribute("next", next.getQuery());
        model.addAttribute("pokemons", pokemons);

        return "inicio";
    }

    @GetMapping("/pokemon/detail")
    public String getDetailPokemon(@RequestParam(name = "search", required = true) String search, Model model) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            ArrayList<Abilities> pokemons = new ArrayList<Abilities>();

            String name = search.toLowerCase();
            Pokemon pokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name + "", Pokemon.class);
            Pokemon urlEvolution = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon-species/" + name + "", Pokemon.class);

            //Consume Evolution Chains
            PrincipalSpecies species = restTemplate.getForObject(urlEvolution.getEvolution_chain().getUrl(), PrincipalSpecies.class);

            Pokemon pokemonP = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + species.getChain().getSpecies().getName() + "", Pokemon.class);
            pokemons.add(pokemonP);

            for (Evolves evolves : species.getChain().getEvolves_to()) {
                Pokemon pokemon1 = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + evolves.getSpecies().getName() + "", Pokemon.class);
                pokemons.add(pokemon1);
                for (Species specie : evolves.getEvolves_to()) {
                    Pokemon pokemon2 = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + specie.getSpecies().getName() + "", Pokemon.class);
                    pokemons.add(pokemon2);
                }
            }

            model.addAttribute("evolutions", pokemons);
            model.addAttribute("pokemon", pokemon != null ? pokemon.getName() : null);
            model.addAttribute("img", pokemon != null ? pokemon.getSprites().getOther() : null);
            model.addAttribute("stats", pokemon != null ? pokemon.getStats() : null);
            model.addAttribute("abilities", pokemon != null ? pokemon.getAbilities() : null);

            return "details";
        } catch (HttpClientErrorException ex) {
            model.addAttribute("error", ex.getResponseBodyAsString());
            return "error";
        }
    }
}
