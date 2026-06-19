package com.skills.hub.service;

import com.skills.hub.model.SkillPack;
import java.util.List;

/**
 * Service interface defining core business operations for managing Skill Packs.
 */
public interface SkillPackService {

    /**
     * Registers and persists a new Skill Pack.
     *
     * @param pack the SkillPack entity containing details to create
     * @return the saved SkillPack entity with its generated database ID
     */
    SkillPack addSkillPack(SkillPack pack);

    /**
     * Retrieves all available Skill Packs from the system.
     *
     * @return a list containing all SkillPack entities
     */
    List<SkillPack> getAllPacks();

    /**
     * Updates an existing Skill Pack's configuration.
     *
     * @param pack the SkillPack entity containing updated data
     * @return the newly updated and persisted SkillPack entity
     */
    SkillPack updateSkillPack(SkillPack pack);

    /**
     * Deletes a specific Skill Pack using its unique database identifier.
     *
     * @param id the unique ID of the Skill Pack to remove
     */
    void deleteSkillPack(Long id);
}
