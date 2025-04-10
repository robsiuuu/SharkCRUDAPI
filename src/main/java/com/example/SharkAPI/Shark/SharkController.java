package com.example.SharkAPI.Shark;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/search/name")
    public String searchSharksByName(@RequestParam("search") String name, Model model) {
        List<Shark> searchResults = sharkService.getSharksByName(name);
        model.addAttribute("sharkList", searchResults);
        model.addAttribute("title", "Search Results for: " + name);
        return "shark-list";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Shark shark = new Shark();
        model.addAttribute("shark", shark);
        model.addAttribute("title", "Create New Shark");
        return "shark-create";
    }

    @PostMapping("/new")
    public Object addNewShark(Shark shark) {
        sharkService.addNewShark(shark);
        return "redirect:/sharks/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int sharkId, Model model) {
        model.addAttribute("shark", sharkService.getSharkById(sharkId));
        model.addAttribute("title", "Update Shark");
        return "shark-update";
    }

    @PostMapping("/update/{id}")
    public Object updateShark(@PathVariable("id") int sharkId, Shark shark) {
        sharkService.updateShark(sharkId, shark);
        return "redirect:/sharks/" + sharkId;
    }

    @GetMapping("/delete/{id}")
    public Object deleteSharkById(@PathVariable("id") int sharkId) {
        sharkService.deleteSharkById(sharkId);
        return "redirect:/sharks/all";
    }

}

