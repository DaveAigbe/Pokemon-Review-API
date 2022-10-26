package com.example.pkreviewapi.controller;

import com.example.pkreviewapi.model.PokemonEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
* 1. To specify controller
* 2. Urls will start with api/whatever
* 3. Get request, Mapping is used after for all request types
* 4. ResponseEntity returns a nicely formatted <whatever> can still be done with normal list
*    represents the whole HTTP response: status code, headers, and body
* 5. Curly brackets indicate where path variable will be stripped from
* 6. PathVariable indicates what the user inputs into the path when the request is called
* 7. If request is successful it will return http created
* 8. RequestBody is what the user inputs into json when making a PUT request
* */


@RestController // 1
@RequestMapping("/api/") // 2
public class PokemonController {

    @GetMapping("pokemon") // 3
    public ResponseEntity<List<PokemonEntity>> getPokemons() { // 4
        List<PokemonEntity> pokemons = new ArrayList<>();
        pokemons.add(new PokemonEntity(1L,"Charmander", "Fire"));
        pokemons.add(new PokemonEntity(2L,"Pikachu", "Electric"));
        pokemons.add(new PokemonEntity(3L,"Squirtle", "Water"));

        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("pokemon/{id}") // 5
    public PokemonEntity getSpecificPokemon(@PathVariable int id) { // 6
        return new PokemonEntity((long) id, "Squritle", "Water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED) // 7
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody PokemonEntity pokemon) { //8
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
    }



}
