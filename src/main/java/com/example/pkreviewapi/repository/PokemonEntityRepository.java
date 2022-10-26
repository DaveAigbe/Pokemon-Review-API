package com.example.pkreviewapi.repository;

import com.example.pkreviewapi.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
