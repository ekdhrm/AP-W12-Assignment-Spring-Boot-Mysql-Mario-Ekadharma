package com.tests.crud.weapons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WeaponController
 *
 * CRUD for Weapons via URL (GET requests + query params).
 *
 * URL patterns:
 * GET /weapons/save?name=&type=&rarity=&baseAtk=&subStat=&passiveName=
 * GET /weapons/update?id=&name=&type=&rarity=&baseAtk=&subStat=&passiveName=
 * GET /weapons/delete?id=
 */
@Controller
@RequestMapping("/weapons")
public class WeaponController {

    private final WeaponRepository weaponRepository;

    public WeaponController(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    // CREATE
    @GetMapping("/save")
    public String save(
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam int rarity,
            @RequestParam int baseAtk,
            @RequestParam String subStat,
            @RequestParam String passiveName) {
        Weapon weapon = new Weapon(name, type, rarity, baseAtk, subStat, passiveName);
        weaponRepository.save(weapon);
        return "redirect:/";
    }

    // UPDATE
    @GetMapping("/update")
    public String update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String type,
            @RequestParam int rarity,
            @RequestParam int baseAtk,
            @RequestParam String subStat,
            @RequestParam String passiveName) {
        weaponRepository.findById(id).ifPresent(w -> {
            w.setName(name);
            w.setType(type);
            w.setRarity(rarity);
            w.setBaseAtk(baseAtk);
            w.setSubStat(subStat);
            w.setPassiveName(passiveName);
            weaponRepository.save(w);
        });
        return "redirect:/";
    }

    // DELETE
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        weaponRepository.deleteById(id);
        return "redirect:/";
    }
}