package com.skills.hub.controller;

import com.skills.hub.model.Subscription;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles subscription operations between users and skill packs.
 */
@Controller
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    /**
     * Subscribe a user to a skill pack.
     *
     * Example:
     * /subscribe?userId=1&packId=2
     */
    @GetMapping("/subscribe")
    public String subscribe(@RequestParam("userId") Long userId,
                            @RequestParam("packId") Long packId) {

        subscriptionService.subscribe(userId, packId);

        return "redirect:/subscriptions/" + userId;
    }

    /**
     * Display all subscriptions for a user.
     *
     * Example:
     * /subscriptions/1
     */
    @GetMapping("/subscriptions/{userId}")
    public String viewSubscriptions(@PathVariable("userId") Long userId,
                                    Model model) {

        List<Subscription> subscriptions =
                subscriptionService.getUserSubscriptions(userId);

        model.addAttribute("subs", subscriptions);
        model.addAttribute("userId", userId);

        return "subscriptions";
    }

    /**
     * Getter for SubscriptionService.
     */
    public SubscriptionService getSubscriptionService() {
        return subscriptionService;
    }
}
