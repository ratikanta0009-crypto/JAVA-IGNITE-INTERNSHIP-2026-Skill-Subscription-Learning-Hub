package com.skills.hub.service.impl;

import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillPackServiceImpl implements SkillPackService {

    private final SkillPackRepository packRepo;

    public SkillPackServiceImpl(SkillPackRepository packRepo) {
        this.packRepo = packRepo;
    }

    @Override
    public SkillPack addSkillPack(SkillPack pack) {
        // STEP 1: validate input
        if (pack == null) {
            throw new IllegalArgumentException("Skill pack cannot be null");
        }

        // STEP 2 & 3: save to DB and return saved object
        return packRepo.save(pack);
    }

    @Override
    public List<SkillPack> getAllPacks() {
        // STEP 1 & 2: fetch all packs from DB and return list
        return packRepo.findAll();
    }

    @Override
    public SkillPack updateSkillPack(SkillPack pack) {
        // STEP 1: find existing pack by ID
        if (pack == null || pack.getId() == null) {
            return null;
        }
        
        Optional<SkillPack> existingPackOpt = packRepo.findById(pack.getId());

        // STEP 2: if not found → return null
        if (!existingPackOpt.isPresent()) {
            return null;
        }

        SkillPack existingPack = existingPackOpt.get();

        // STEP 3: update fields (assuming your model has these standard fields)
        existingPack.setName(pack.getName());
        existingPack.setDescription(pack.getDescription());
        // Add any other specific fields your SkillPack model contains here

        // STEP 4 & 5: save updated pack and return it
        return packRepo.save(existingPack);
    }

    @Override
    public void deleteSkillPack(Long id) {
        // STEP 1: delete pack by ID
        if (id != null && packRepo.existsById(id)) {
            packRepo.deleteById(id);
        }
    }

    public SkillPackRepository getPackRepo() {
        return packRepo;
    }
}
