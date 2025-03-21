package com.example.SharkAPI;

import jakarta.persistence.*;

@Entity
@Table(name = "sharks")
public class Shark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sharkId;

    @Column(nullable = false)
    private String name;

    private String description;

    private String species;

    // Constructors
    public Shark() {

    }

    public Shark(int sharkId, String name, String description, String species) {
        this.sharkId = sharkId;
        this.name = name;
        this.description = description;
        this.species = species;
    }

    // Getters and Setters
    public int getSharkId() {
        return sharkId;
    }

    public void setSharkId(int sharkId) {
        this.sharkId = sharkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}

