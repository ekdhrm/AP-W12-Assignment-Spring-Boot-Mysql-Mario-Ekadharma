package com.tests.crud.orang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orang")
public class OrangController {

    private final OrangRepository orangRepository;

    public OrangController(OrangRepository orangRepository) {
        this.orangRepository = orangRepository;
    }

     // CREATE
    @GetMapping("/save")
    public String save(
            @RequestParam String name,
            @RequestParam String nim,
            @RequestParam int kill,
            @RequestParam int death,
            @RequestParam int assist) {
        Orang orang = new Orang(name, nim, kill, death, assist);
        orangRepository.save(orang);
        return "redirect:/";
    }
}
