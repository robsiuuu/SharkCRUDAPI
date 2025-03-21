package com.example.SharkAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharkService {

    @Autowired
    private SharkRepository sharkRepository;

    /**
     * Fetch all Sharks.
     *
     * @return the list of all Sharks.
     */
    public List<Shark> getAllSharks() {
        return sharkRepository.findAll();
    }

    /**
     * Fetch a unique Shark.
     *
     * @param sharkId the unique Shark id.
     * @return a unique Shark object.
     */
    public Shark getSharkById(int sharkId) {
        return sharkRepository.findById(sharkId).orElse(null);
    }

    /**
     * Fetch all sharks whose species matches the search term.
     *
     * @param species the search key.
     * @return the list of matching Sharks.
     */
    public List<Shark> getSharksBySpecies(String species) {
        return sharkRepository.getSharksBySpecies(species);
    }

    /**
     * Fetch all sharks with a name that contains the given string.
     *
     * @param name the search name
     * @return the list of matching Sharks
     */
    public List<Shark> getSharksByName(String name) {
        return sharkRepository.getSharksByName(name);
    }

    /**
     * Add a new Shark to the database.
     *
     * @param shark the new Shark to add.
     */
    public void addNewShark(Shark shark) {
        sharkRepository.save(shark);
    }

    /**
     * Update an existing Shark.
     *
     * @param sharkId the unique Shark Id.
     * @param shark   the new Shark details.
     */
    public void updateShark(int sharkId, Shark shark) {
        Shark existing = getSharkById(sharkId);
        existing.setName(shark.getName());
        existing.setDescription(shark.getDescription());
        existing.setSpecies(shark.getSpecies());

        // The save method merges by default.
        sharkRepository.save(existing);
    }

    /**
     * Delete a unique Shark.
     *
     * @param sharkId the unique Shark Id.
     */
    public void deleteSharkById(int sharkId) {
        sharkRepository.deleteById(sharkId);
    }

}