package com.tests.crud.player_resources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PlayerResource.java
 *
 * Represents a resource in the player's inventory in Wuthering Waves.
 * Examples: Astrite (premium currency), Shell Credits, Waveplates, ascension
 * materials.
 *
 * OOP: Encapsulation, constructor, getters/setters, custom method.
 */
@Entity
@Table(name = "player_resources")
public class PlayerResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Resource name — e.g., "Astrite", "Shell Credits", "Waveplates"
    @Column(nullable = false)
    private String resourceName;

    // Category — Currency, Ascension, Skill, Echo, Event
    @Column(nullable = false)
    private String resourceType;

    // How many the player currently holds
    @Column(nullable = false)
    private int quantity;

    // Short description of what it is used for
    @Column(nullable = false, length = 512)
    private String description;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public PlayerResource() {
    }

    public PlayerResource(String resourceName, String resourceType,
            int quantity, String description) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.quantity = quantity;
        this.description = description;
    }

    // -------------------------------------------------------------------------
    // Custom method — returns how plentiful the resource is
    // -------------------------------------------------------------------------

    public String getStockStatus() {
        if (quantity == 0)
            return "Empty";
        if (quantity < 10)
            return "Low";
        if (quantity < 100)
            return "Moderate";
        return "Abundant";
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    // -------------------------------------------------------------------------
    // Setters
    // -------------------------------------------------------------------------

    public void setId(Integer id) {
        this.id = id;
    }

    public void setResourceName(String rn) {
        this.resourceName = rn;
    }

    public void setResourceType(String rt) {
        this.resourceType = rt;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String d) {
        this.description = d;
    }
}