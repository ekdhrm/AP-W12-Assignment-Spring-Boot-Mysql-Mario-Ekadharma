package com.tests.crud.echoes_set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EchoSetController
 *
 * CRUD for Echo Sets via URL (GET requests + query params).
 *
 * URL patterns:
 * GET /echosets/save?name=&twoPieceBonus=&fivePieceBonus=&recommendedFor=
 * GET /echosets/update?id=&name=&twoPieceBonus=&fivePieceBonus=&recommendedFor=
 * GET /echosets/delete?id=
 */
@Controller
@RequestMapping("/echosets")
public class EchoSetController {

    private final EchoSetRepository echoSetRepository;

    public EchoSetController(EchoSetRepository echoSetRepository) {
        this.echoSetRepository = echoSetRepository;
    }

    // CREATE
    @GetMapping("/save")
    public String save(
            @RequestParam String name,
            @RequestParam String twoPieceBonus,
            @RequestParam String fivePieceBonus,
            @RequestParam String recommendedFor) {
        EchoSet set = new EchoSet(name, twoPieceBonus, fivePieceBonus, recommendedFor);
        echoSetRepository.save(set);
        return "redirect:/";
    }

    // UPDATE
    @GetMapping("/update")
    public String update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String twoPieceBonus,
            @RequestParam String fivePieceBonus,
            @RequestParam String recommendedFor) {
        echoSetRepository.findById(id).ifPresent(s -> {
            s.setName(name);
            s.setTwoPieceBonus(twoPieceBonus);
            s.setFivePieceBonus(fivePieceBonus);
            s.setRecommendedFor(recommendedFor);
            echoSetRepository.save(s);
        });
        return "redirect:/";
    }

    // DELETE
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        echoSetRepository.deleteById(id);
        return "redirect:/";
    }
}