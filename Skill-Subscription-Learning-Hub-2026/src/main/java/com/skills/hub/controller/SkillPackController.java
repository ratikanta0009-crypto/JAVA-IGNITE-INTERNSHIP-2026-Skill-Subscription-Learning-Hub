package com.skills.hub.controller;

import com.skills.hub.model.SkillPack;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Handles skill pack (course) web operations.
 */
@Controller
public class SkillPackController {

    private final SkillPackService packService;

    // Constructor injection is preferred over @Autowired for better testability
    public SkillPackController(SkillPackService packService) {
        this.packService = packService;
    }

    /**
     * Fetches all skill packs and displays them on the packs page.
     */
    @GetMapping("/packs")
    public String viewPacks(Model model) {
        List<SkillPack> list = packService.getAllPacks();
        model.addAttribute("packs", list);
        return "packs"; // Resolves to packs.jsp
    }

    /**
     * Displays the form to add a new skill pack.
     */
    @GetMapping("/add-pack")
    public String showAddPackPage() {
        return "add-pack"; // Resolves to add-pack.jsp
    }

    /**
     * Processes the submission form to create a new skill pack.
     */
    @PostMapping("/add-pack")
    public String addPack(@ModelAttribute SkillPack pack) {
        packService.addSkillPack(pack);
        return "redirect:/packs"; // Prevents duplicate form submissions on page refresh
    }

    /**
     * Deletes a specific skill pack by its ID.
     */
    @GetMapping("/delete-pack/{id}")
    public String deletePack(@PathVariable Long id) {
        packService.deleteSkillPack(id);
        return "redirect:/packs";
    }

    // Getter for the service bean (useful if needed for specific framework hooks or unit tests)
    public SkillPackService getPackService() {
        return packService;
    }
}
