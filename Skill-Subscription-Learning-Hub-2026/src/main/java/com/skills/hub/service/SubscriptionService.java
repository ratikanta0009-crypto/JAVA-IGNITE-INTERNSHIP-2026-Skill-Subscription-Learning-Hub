package com.skills.hub.service.impl;

import com.skills.hub.model.SkillPack;
import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepo;
    private final UserRepository userRepo;
    private final SkillPackRepository packRepo;

    // Constructor injection for repositories
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo, 
                                   UserRepository userRepo, 
                                   SkillPackRepository packRepo) {
        this.subscriptionRepo = subscriptionRepo;
        this.userRepo = userRepo;
        this.packRepo = packRepo;
    }

    @Override
    @Transactional
    public Subscription subscribe(Long userId, Long packId) {
        // 1. Fetch the user from the database
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        // 2. Fetch the skill pack from the database
        SkillPack pack = packRepo.findById(packId)
                .orElseThrow(() -> new IllegalArgumentException("Skill Pack not found with ID: " + packId));

        // Optional: Check if the user is already subscribed to avoid duplicate subscriptions
        boolean alreadySubscribed = subscriptionRepo.existsByUserIdAndSkillPackId(userId, packId);
        if (alreadySubscribed) {
            throw new IllegalStateException("User is already subscribed to this skill pack.");
        }

        // 3. Create a new subscription record
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setSkillPack(pack);
        subscription.setSubscriptionDate(LocalDateTime.now()); // Sets the current timestamp
        subscription.setStatus("ACTIVE");

        // 4. Save and return the subscription entity
        return subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        
        // Fetches all subscription records mapping to this specific user ID
        return subscriptionRepo.findByUserId(userId);
    }
}
