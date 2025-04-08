package com.example.SharkAPI.Shark;

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

    private String imagePath;

    // Constructors
    public Shark() {
    }

    public Shark(int sharkId, String name, String description, String species, String imagePath) {
        this.sharkId = sharkId;
        this.name = name;
        this.description = description;
        this.species = species;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "sharkId=" + sharkId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", species='" + species + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}

