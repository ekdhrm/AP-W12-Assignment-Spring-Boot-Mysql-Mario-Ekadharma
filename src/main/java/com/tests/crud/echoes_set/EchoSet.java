package com.tests.crud.echoes_set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * EchoSet.java
 *
 * Represents an Echo Set (gear set) in Wuthering Waves.
 * Patch 3.3 introduced "Wishes of Quiet Snowfall" and "Reel of Spliced
 * Memories".
 *
 * OOP: Encapsulation, constructor, getters/setters, custom method.
 */
@Entity
@Table(name = "echo_sets")
public class EchoSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Set name — e.g., "Wishes of Quiet Snowfall"
    @Column(nullable = false)
    private String name;

    // 2-piece bonus description
    @Column(nullable = false, length = 512)
    private String twoPieceBonus;

    // 5-piece bonus description
    @Column(nullable = false, length = 1024)
    private String fivePieceBonus;

    // Which Resonator type benefits most from this set
    @Column(nullable = false)
    private String recommendedFor;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public EchoSet() {
    }

    public EchoSet(String name, String twoPieceBonus,
            String fivePieceBonus, String recommendedFor) {
        this.name = name;
        this.twoPieceBonus = twoPieceBonus;
        this.fivePieceBonus = fivePieceBonus;
        this.recommendedFor = recommendedFor;
    }

    // -------------------------------------------------------------------------
    // Custom method — summary of the set in one line
    // -------------------------------------------------------------------------

    public String getSummary() {
        return name + " → Recommended for: " + recommendedFor;
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

    public String getTwoPieceBonus() {
        return twoPieceBonus;
    }

    public String getFivePieceBonus() {
        return fivePieceBonus;
    }

    public String getRecommendedFor() {
        return recommendedFor;
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

    public void setTwoPieceBonus(String b) {
        this.twoPieceBonus = b;
    }

    public void setFivePieceBonus(String b) {
        this.fivePieceBonus = b;
    }

    public void setRecommendedFor(String r) {
        this.recommendedFor = r;
    }
}