package com.example.SharkAPI.Shark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sharks")
public class SharkController {

    @Autowired
    private SharkService sharkService;

    /**
     * Get all sharks.
     *
     * @return list of all sharks.
     */
    @GetMapping("/all")
    public Object getAllSharks(Model model) {
        model.addAttribute("sharkList", sharkService.getAllSharks());
        model.addAttribute("title", "All Sharks");
        return "shark-list";
    }

    /**
     * Get a shark by ID.
     *
     * @param sharkId the shark's unique ID.
     * @return the Shark object or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Shark> getSharkById(@PathVariable("id") int sharkId) {
        Shark shark = sharkService.getSharkById(sharkId);
        return (shark != null) ? ResponseEntity.ok(shark) : ResponseEntity.notFound().build();
    }

    /**
     * Get sharks by species.
     *
     * @param species the species name.
     * @return list of sharks matching the species.
     */
    @GetMapping("/species/{species}")
    public List<Shark> getSharksBySpecies(@PathVariable String species) {
        return sharkService.getSharksBySpecies(species);
    }

    /**
     * Get sharks by name search.
     *
     * @param name the search term.
     * @return list of sharks whose names contain the given term.
     */
    @GetMapping("/search/{name}")
    public List<Shark> getSharksByName(@PathVariable String name) {
        return sharkService.getSharksByName(name);
    }

    /**
     * Add a new shark.
     *
     * @param shark the new Shark object.
     * @return the added Shark.
     */
    @PostMapping("/new")
    public Object addNewShark(@RequestBody Shark shark) {
        sharkService.addNewShark(shark);
        return new ResponseEntity<>(sharkService.getAllSharks(), HttpStatus.CREATED);
    }

    /**
     * Update an existing shark.
     *
     * @param sharkId the unique Shark ID.
     * @param shark   the updated Shark object.
     * @return the updated Shark or 404 if not found.
     */
    @PutMapping("/{id}")
    public Object updateShark(@PathVariable("id") int sharkId, @RequestBody Shark shark) {
        sharkService.updateShark(sharkId, shark);
        return new ResponseEntity<>(sharkService.getSharkById(sharkId), HttpStatus.CREATED);
    }

    /**
     * Delete a shark by ID.
     *
     * @param sharkId the unique Shark ID.
     * @return a success message or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public Object deleteSharkById(@PathVariable("id") int sharkId) {
        sharkService.deleteSharkById(sharkId);
        return new ResponseEntity<>(sharkService.getAllSharks(), HttpStatus.OK);
    }

}

