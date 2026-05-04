package com.tests.crud.resonators;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ResonatorController
 *
 * Handles all CRUD operations for Resonators via URL (GET requests).
 * All operations redirect back to "/" so the main page always reflects latest
 * data.
 *
 * URL patterns:
 * GET
 * /resonators/save?name=&element=&weaponType=&rarity=&role=&region=&available=
 * GET
 * /resonators/update?id=&name=&element=&weaponType=&rarity=&role=&region=&available=
 * GET /resonators/delete?id=
 */
@Controller
@RequestMapping("/resonators")
public class ResonatorController {

    private final ResonatorRepository resonatorRepository;

    // Constructor injection — Spring injects the repository automatically
    public ResonatorController(ResonatorRepository resonatorRepository) {
        this.resonatorRepository = resonatorRepository;
    }

    // -------------------------------------------------------------------------
    // CREATE — save a new Resonator
    // Example:
    // /resonators/save?name=Hiyuki&element=Glacio&weaponType=Sword&rarity=5&role=DPS&region=Lahai-Roi&available=true
    // -------------------------------------------------------------------------
    @GetMapping("/save")
    public String save(
            @RequestParam String name,
            @RequestParam String element,
            @RequestParam String weaponType,
            @RequestParam int rarity,
            @RequestParam String role,
            @RequestParam String region,
            @RequestParam(defaultValue = "true") boolean available) {
        Resonator resonator = new Resonator(name, element, weaponType, rarity, role, region, available);
        resonatorRepository.save(resonator);
        return "redirect:/";
    }

    // -------------------------------------------------------------------------
    // UPDATE — find by id and update all fields
    // Example:
    // /resonators/update?id=1&name=Hiyuki&element=Glacio&weaponType=Sword&rarity=5&role=Support&region=Lahai-Roi&available=true
    // -------------------------------------------------------------------------
    @GetMapping("/update")
    public String update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String element,
            @RequestParam String weaponType,
            @RequestParam int rarity,
            @RequestParam String role,
            @RequestParam String region,
            @RequestParam(defaultValue = "true") boolean available) {
        resonatorRepository.findById(id).ifPresent(r -> {
            r.setName(name);
            r.setElement(element);
            r.setWeaponType(weaponType);
            r.setRarity(rarity);
            r.setRole(role);
            r.setRegion(region);
            r.setAvailable(available);
            resonatorRepository.save(r);
        });
        return "redirect:/";
    }

    // -------------------------------------------------------------------------
    // DELETE — remove by id
    // Example: /resonators/delete?id=1
    // -------------------------------------------------------------------------
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        resonatorRepository.deleteById(id);
        return "redirect:/";
    }
}