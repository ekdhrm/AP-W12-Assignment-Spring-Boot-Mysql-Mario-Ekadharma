package com.tests.crud.bosses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * BossController
 *
 * CRUD for Bosses via URL (GET requests + query params).
 *
 * URL patterns:
 * GET /bosses/save?name=&bossType=&element=&location=&echoReward=&weekly=
 * GET /bosses/update?id=&name=&bossType=&element=&location=&echoReward=&weekly=
 * GET /bosses/delete?id=
 */
@Controller
@RequestMapping("/bosses")
public class BossController {

    private final BossRepository bossRepository;

    public BossController(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    // CREATE
    @GetMapping("/save")
    public String save(
            @RequestParam String name,
            @RequestParam String bossType,
            @RequestParam String element,
            @RequestParam String location,
            @RequestParam String echoReward,
            @RequestParam(defaultValue = "false") boolean weekly) {
        Boss boss = new Boss(name, bossType, element, location, echoReward, weekly);
        bossRepository.save(boss);
        return "redirect:/";
    }

    // UPDATE
    @GetMapping("/update")
    public String update(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String bossType,
            @RequestParam String element,
            @RequestParam String location,
            @RequestParam String echoReward,
            @RequestParam(defaultValue = "false") boolean weekly) {
        bossRepository.findById(id).ifPresent(b -> {
            b.setName(name);
            b.setBossType(bossType);
            b.setElement(element);
            b.setLocation(location);
            b.setEchoReward(echoReward);
            b.setWeekly(weekly);
            bossRepository.save(b);
        });
        return "redirect:/";
    }

    // DELETE
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        bossRepository.deleteById(id);
        return "redirect:/";
    }
}