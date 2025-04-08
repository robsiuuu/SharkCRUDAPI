package com.example.SharkAPI.Shark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharkService {

    @Autowired
    private SharkRepository sharkRepository;

    public List<Shark> getAllSharks() {
        return sharkRepository.findAll();
    }

    public Shark getSharkById(int sharkId) {
        return sharkRepository.findById(sharkId).orElse(null);
    }

    public Integer getNextSharkId(int currentId) {
        return sharkRepository.findNextId(currentId);
    }

    public Integer getPreviousSharkId(int currentId) {
        return sharkRepository.findPreviousId(currentId);
    }

    public List<Shark> getSharksBySpecies(String species) {
        return sharkRepository.getSharksBySpecies(species);
    }

    public List<Shark> getSharksByName(String name) {
        return sharkRepository.getSharksByName(name);
    }

    public void addNewShark(Shark shark) {
        sharkRepository.save(shark);
    }

    public void updateShark(int sharkId, Shark shark) {
        Shark existing = getSharkById(sharkId);
        existing.setName(shark.getName());
        existing.setDescription(shark.getDescription());
        existing.setSpecies(shark.getSpecies());

        // The save method merges by default.
        sharkRepository.save(existing);
    }

    public void deleteSharkById(int sharkId) {
        sharkRepository.deleteById(sharkId);
    }



}