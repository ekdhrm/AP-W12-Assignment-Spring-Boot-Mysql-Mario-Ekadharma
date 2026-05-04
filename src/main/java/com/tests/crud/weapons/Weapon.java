package com.tests.crud.weapons;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Weapon.java
 *
 * Represents an equippable weapon in Wuthering Waves.
 * Patch 3.3 introduced Frostburn and Forged Dwarf Star as new 5-star weapons.
 *
 * OOP: Encapsulation applied — all fields private with getters/setters.
 */
@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Weapon name — e.g., "Frostburn", "Forged Dwarf Star"
    @Column(nullable = false)
    private String name;

    // Weapon category — Sword, Broadblade, Pistols, Gauntlets, Rectifier
    @Column(nullable = false)
    private String type;

    // Star rarity — 3, 4, or 5
    @Column(nullable = false)
    private int rarity;

    // Base ATK stat at max level
    @Column(nullable = false)
    private int baseAtk;

    // Secondary stat — e.g., "Crit Rate", "ATK%", "Energy Regen"
    @Column(nullable = false)
    private String subStat;

    // Passive/skill effect name — e.g., "Frostbite", "Stellar Collapse"
    @Column(nullable = false)
    private String passiveName;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public Weapon() {
    }

    public Weapon(String name, String type, int rarity,
            int baseAtk, String subStat, String passiveName) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.baseAtk = baseAtk;
        this.subStat = subStat;
        this.passiveName = passiveName;
    }

    // -------------------------------------------------------------------------
    // Custom method — returns weapon type abbreviation for display
    // -------------------------------------------------------------------------

    public String getTypeShort() {
        return switch (type) {
            case "Broadblade" -> "BB";
            case "Gauntlets" -> "GNT";
            case "Rectifier" -> "RCT";
            case "Pistols" -> "PST";
            case "Sword" -> "SWD";
            default -> type;
        };
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getRarity() {
        return rarity;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public String getSubStat() {
        return subStat;
    }

    public String getPassiveName() {
        return passiveName;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public void setSubStat(String subStat) {
        this.subStat = subStat;
    }

    public void setPassiveName(String pn) {
        this.passiveName = pn;
    }
}