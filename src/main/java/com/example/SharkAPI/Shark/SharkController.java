package com.example.SharkAPI.Shark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sharks")
public class SharkController {

    @Autowired
    private SharkService sharkService;

    @GetMapping("/all")
    public Object getAllSharks(Model model) {
        model.addAttribute("sharkList", sharkService.getAllSharks());
        model.addAttribute("title", "All Sharks");
        return "shark-list";
    }

    @GetMapping("/{id}")
    public String getSharkById(@PathVariable("id") int sharkId, Model model) {
        Shark shark = sharkService.getSharkById(sharkId);

        Integer nextId = sharkService.getNextSharkId(sharkId);
        Integer prevId = sharkService.getPreviousSharkId(sharkId);

        model.addAttribute("shark", shark);
        model.addAttribute("nextSharkId", nextId);
        model.addAttribute("prevSharkId", prevId);
        return "shark-details";
    }

    @GetMapping("/species/{species}")
    public List<Shark> getSharksBySpecies(@PathVariable String species) {
        return sharkService.getSharksBySpecies(species);
    }

    @GetMapping("/search/{name}")
    public List<Shark> getSharksByName(@PathVariable String name) {
        return sharkService.getSharksByName(name);
    }

    @PostMapping("/new")
    public Object addNewShark(@RequestBody Shark shark) {
        sharkService.addNewShark(shark);
        return new ResponseEntity<>(sharkService.getAllSharks(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Object updateShark(@PathVariable("id") int sharkId, @RequestBody Shark shark) {
        sharkService.updateShark(sharkId, shark);
        return new ResponseEntity<>(sharkService.getSharkById(sharkId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Object deleteSharkById(@PathVariable("id") int sharkId) {
        sharkService.deleteSharkById(sharkId);
        return new ResponseEntity<>(sharkService.getAllSharks(), HttpStatus.OK);
    }

}

