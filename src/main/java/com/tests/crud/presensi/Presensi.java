package com.tests.crud.presensi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presensi")
public class Presensi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nim;

    @Column(nullable = false)
    private String status;

    public Presensi() {}

    public Presensi(String name, String nim, String status) {
        this.name = name;
        this.nim = nim;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

