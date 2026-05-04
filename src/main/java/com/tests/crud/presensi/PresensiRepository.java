package com.tests.crud.presensi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PresensiRepository extends CrudRepository<Presensi, Integer> {
    List<Presensi> findByStatus(String status);
}