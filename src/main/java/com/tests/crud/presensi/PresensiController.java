package com.tests.crud.presensi;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PresensiController {
    private final PresensiRepository presensiRepository;

    public PresensiController(PresensiRepository presensiRepository) {
        this.presensiRepository = presensiRepository;
    }

    @GetMapping
    public String getAllPresensi(Model model) {
        List<Presensi> presentList = presensiRepository.findByStatus("PRESENT");
        List<Presensi> absentList = presensiRepository.findByStatus("ABSENT");

        model.addAttribute("presentList", presentList);
        model.addAttribute("absentList", absentList);

        return "index";
    }

    // READ ALL (API Model)
    public Iterable<Presensi> getAllPresensi() {
        return presensiRepository.findAll();
    }

    // CREATE via URL
    @GetMapping("/add")
    public String add(
            @RequestParam String name,
            @RequestParam String nim,
            @RequestParam String status) {
        Presensi presensi = new Presensi(name, nim, status.toUpperCase());
        presensiRepository.save(presensi);
        return "redirect:/";
    }

    // UPDATE via URL
    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestParam String status) {
        Presensi presensi = presensiRepository.findById(id).orElse(null);
        if (presensi != null) {
            presensi.setStatus(status.toUpperCase());
            presensiRepository.save(presensi);
        }
        return "redirect:/";
    }

    // DELETE via URL
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        presensiRepository.deleteById(id);
        return "redirect:/";
    }
}