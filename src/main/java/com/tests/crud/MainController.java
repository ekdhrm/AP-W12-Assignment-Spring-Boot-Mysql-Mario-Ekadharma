package com.tests.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tests.crud.bosses.BossRepository;
import com.tests.crud.echoes_set.EchoSetRepository;
import com.tests.crud.player_resources.PlayerResourceRepository;
import com.tests.crud.resonators.ResonatorRepository;
import com.tests.crud.weapons.WeaponRepository;

/**
 * HomeController
 *
 * Serves the single-page dashboard at "/".
 * Reads all data from all 5 repositories and puts them into the Model
 * so Thymeleaf can display them all on one page.
 *
 * Single Responsibility: this controller only reads and serves the view.
 * Each entity's CRUD is handled by its own controller.
 */
@Controller
public class MainController {

    private final ResonatorRepository resonatorRepository;
    private final WeaponRepository weaponRepository;
    private final BossRepository bossRepository;
    private final EchoSetRepository echoSetRepository;
    private final PlayerResourceRepository playerResourceRepository;

    // Spring injects all repositories via constructor injection
    public MainController(
            ResonatorRepository resonatorRepository,
            WeaponRepository weaponRepository,
            BossRepository bossRepository,
            EchoSetRepository echoSetRepository,
            PlayerResourceRepository playerResourceRepository) {
        this.resonatorRepository = resonatorRepository;
        this.weaponRepository = weaponRepository;
        this.bossRepository = bossRepository;
        this.echoSetRepository = echoSetRepository;
        this.playerResourceRepository = playerResourceRepository;
    }

    /**
     * Handles GET "/" — renders index.html with all data loaded.
     * Thymeleaf accesses each list via ${resonators}, ${weapons}, etc.
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("resonators", resonatorRepository.findAll());
        model.addAttribute("weapons", weaponRepository.findAll());
        model.addAttribute("bosses", bossRepository.findAll());
        model.addAttribute("echoSets", echoSetRepository.findAll());
        model.addAttribute("resources", playerResourceRepository.findAll());
        return "index";
    }
}