package com.tests.crud.player_resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PlayerResourceController
 *
 * CRUD for Player Resources via URL (GET requests + query params).
 *
 * URL patterns:
 * GET /resources/save?resourceName=&resourceType=&quantity=&description=
 * GET /resources/update?id=&resourceName=&resourceType=&quantity=&description=
 * GET /resources/delete?id=
 */
@Controller
@RequestMapping("/resources")
public class PlayerResourceController {

    private final PlayerResourceRepository playerResourceRepository;

    public PlayerResourceController(PlayerResourceRepository playerResourceRepository) {
        this.playerResourceRepository = playerResourceRepository;
    }

    // CREATE
    @GetMapping("/save")
    public String save(
            @RequestParam String resourceName,
            @RequestParam String resourceType,
            @RequestParam int quantity,
            @RequestParam String description) {
        PlayerResource resource = new PlayerResource(resourceName, resourceType, quantity, description);
        playerResourceRepository.save(resource);
        return "redirect:/";
    }

    // UPDATE
    @GetMapping("/update")
    public String update(
            @RequestParam Integer id,
            @RequestParam String resourceName,
            @RequestParam String resourceType,
            @RequestParam int quantity,
            @RequestParam String description) {
        playerResourceRepository.findById(id).ifPresent(r -> {
            r.setResourceName(resourceName);
            r.setResourceType(resourceType);
            r.setQuantity(quantity);
            r.setDescription(description);
            playerResourceRepository.save(r);
        });
        return "redirect:/";
    }

    // DELETE
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        playerResourceRepository.deleteById(id);
        return "redirect:/";
    }
}