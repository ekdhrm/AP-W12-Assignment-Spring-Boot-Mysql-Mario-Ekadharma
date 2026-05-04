package com.tests.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tests.crud.presensi.PresensiController;


@Controller
public class MainController {
    private final PresensiController presensiController;

    public MainController(PresensiController presensiController) {
        this.presensiController = presensiController;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("presensi", presensiController.getAllPresensi());
        return "index";
    }
}