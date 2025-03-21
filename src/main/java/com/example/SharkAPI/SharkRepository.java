package com.example.SharkAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharkRepository extends JpaRepository<Shark, Integer> {

    /**
     * Find all sharks by species.
     *
     * @param species the species to search for.
     * @return a list of sharks matching the species.
     */
    @Query("SELECT s FROM Shark s WHERE s.species = :species")
    List<Shark> getSharksBySpecies(String species);

    /**
     * Find sharks whose name contains the given string (case insensitive).
     *
     * @param name the search term.
     * @return a list of matching sharks.
     */
    @Query("SELECT s FROM Shark s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Shark> getSharksByName(String name);
}


