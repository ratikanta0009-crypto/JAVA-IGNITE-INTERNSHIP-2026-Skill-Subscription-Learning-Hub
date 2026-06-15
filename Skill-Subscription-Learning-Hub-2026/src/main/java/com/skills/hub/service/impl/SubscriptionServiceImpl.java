package com.skills.hub.service.impl;

import com.skills.hub.model.Subscription;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;

    public SubscriptionServiceImpl(SubscriptionRepository subRepo) {
        this.subRepo = subRepo;
    }

    @Override
    public Subscription subscribe(Long userId, Long packId) {

        // =========================
        // to-do
        // =========================
        // STEP 1: fetch user by id (via repo/service)
        // STEP 2: fetch skill pack by id
        // STEP 3: create new Subscription object
        // STEP 4: set user + skill pack
        // STEP 5: set start date = today
        // STEP 6: set end date = today + 30 days
        // STEP 7: set status = ACTIVE
        // STEP 8: save subscription
        // STEP 9: return subscription

        return null;
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {

        // STEP 1: fetch user subscriptions from DB
        // STEP 2: return list

        return null;
    }

	public SubscriptionRepository getSubRepo() {
		return subRepo;
	}
}