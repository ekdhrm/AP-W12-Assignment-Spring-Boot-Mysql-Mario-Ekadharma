package com.tests.crud.orang;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orang")
public class Orang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nim;

    @Column(nullable = false)
    private int kill;

    @Column(nullable = false)
    private int death;

    @Column(nullable = false)
    private int assist;

    public Orang() {
    }

    public Orang(String name, String nim, int kill, int death, int assist) {
        this.name = name;
        this.nim = nim;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public int getKill() {
        return kill;
    }

    public int getDeath() {
        return death;
    }

    public int getAssist() {
        return assist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public String getKDA() {
        return switch (death) {
            case 0 -> "Perfect KDA";
            default -> String.format("%.2f", (float) (kill + assist) / death);
        };
    }
}

