package com.example.SharkAPI.Shark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharkRepository extends JpaRepository<Shark, Integer> {

    @Query("SELECT s FROM Shark s WHERE s.species = :species")
    List<Shark> getSharksBySpecies(String species);

    @Query("SELECT s FROM Shark s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Shark> getSharksByName(String name);

    @Query(value = "SELECT MIN(s.sharkId) FROM Shark s WHERE s.sharkId > :currentId")
    Integer findNextId(@Param("currentId") int currentId);

    @Query(value = "SELECT MAX(s.sharkId) FROM Shark s WHERE s.sharkId < :currentId")
    Integer findPreviousId(@Param("currentId") int currentId);

}


