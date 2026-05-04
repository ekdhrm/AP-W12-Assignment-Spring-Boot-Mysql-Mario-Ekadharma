package com.tests.crud.bosses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Boss.java
 *
 * Represents an enemy boss in Wuthering Waves.
 * Boss types: Overlord (weekly/world), Elite, Common.
 *
 * OOP: Encapsulation — private fields, constructor, getters, setters, custom
 * method.
 */
@Entity
@Table(name = "bosses")
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Boss name — e.g., "Threnodian Aleph-1", "Exostrider"
    @Column(nullable = false)
    private String name;

    // Boss tier — Overlord, Elite, Common
    @Column(nullable = false)
    private String bossType;

    // Element — Glacio, Fusion, Aero, Electro, Spectro, Havoc, None
    @Column(nullable = false)
    private String element;

    // Map location — e.g., "Dimmr Plains", "Lahai-Roi"
    @Column(nullable = false)
    private String location;

    // Echo name dropped by this boss
    @Column(nullable = false)
    private String echoReward;

    // True if this is a weekly boss (limited attempts per week)
    @Column(nullable = false)
    private boolean weekly;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public Boss() {
    }

    public Boss(String name, String bossType, String element,
            String location, String echoReward, boolean weekly) {
        this.name = name;
        this.bossType = bossType;
        this.element = element;
        this.location = location;
        this.echoReward = echoReward;
        this.weekly = weekly;
    }

    // -------------------------------------------------------------------------
    // Custom method — returns challenge priority label
    // -------------------------------------------------------------------------

    public String getPriorityLabel() {
        if (weekly)
            return "Weekly Challenge";
        if ("Overlord".equals(bossType))
            return "High Priority";
        if ("Elite".equals(bossType))
            return "Medium Priority";
        return "Standard";
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

    public String getBossType() {
        return bossType;
    }

    public String getElement() {
        return element;
    }

    public String getLocation() {
        return location;
    }

    public String getEchoReward() {
        return echoReward;
    }

    public boolean isWeekly() {
        return weekly;
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

    public void setBossType(String bossType) {
        this.bossType = bossType;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEchoReward(String er) {
        this.echoReward = er;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }
}