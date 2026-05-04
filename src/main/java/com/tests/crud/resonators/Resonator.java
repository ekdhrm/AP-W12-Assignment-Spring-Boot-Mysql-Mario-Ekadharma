package com.tests.crud.resonators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Resonator.java
 *
 * Represents a playable character (Resonator) in Wuthering Waves.
 * As of patch 3.3, there are 46 playable Resonators including
 * new additions Hiyuki (Glacio) and Denia (Fusion).
 *
 * OOP: Encapsulation — all fields are private, accessed via getters/setters.
 */
@Entity
@Table(name = "resonators")
public class Resonator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Character name — e.g., "Hiyuki", "Denia", "Mornye"
    @Column(nullable = false)
    private String name;

    // Element type — Glacio, Fusion, Aero, Electro, Spectro, Havoc
    @Column(nullable = false)
    private String element;

    // Weapon type — Sword, Broadblade, Pistols, Gauntlets, Rectifier
    @Column(nullable = false)
    private String weaponType;

    // Star rarity — 4 or 5
    @Column(nullable = false)
    private int rarity;

    // Combat role — DPS, Sub-DPS, Support, Healer
    @Column(nullable = false)
    private String role;

    // Home region — Jinzhou, Rinascita, Lahai-Roi, etc.
    @Column(nullable = false)
    private String region;

    // Whether this character is currently on banner / available
    @Column(nullable = false)
    private boolean available;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public Resonator() {
    }

    public Resonator(String name, String element, String weaponType,
            int rarity, String role, String region, boolean available) {
        this.name = name;
        this.element = element;
        this.weaponType = weaponType;
        this.rarity = rarity;
        this.role = role;
        this.region = region;
        this.available = available;
    }

    // -------------------------------------------------------------------------
    // Custom method — returns the star emoji string based on rarity
    // -------------------------------------------------------------------------

    public String getStars() {
        return "★".repeat(rarity);
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

    public String getElement() {
        return element;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getRarity() {
        return rarity;
    }

    public String getRole() {
        return role;
    }

    public String getRegion() {
        return region;
    }

    public boolean isAvailable() {
        return available;
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

    public void setElement(String element) {
        this.element = element;
    }

    public void setWeaponType(String wt) {
        this.weaponType = wt;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setAvailable(boolean a) {
        this.available = a;
    }
}