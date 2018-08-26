package io.github.stayhungrystayfoolish.service;

import io.github.stayhungrystayfoolish.domain.JhiResource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing JhiResource.
 */
public interface JhiResourceService {

    /**
     * Save a jhiResource.
     *
     * @param jhiResource the entity to save
     * @return the persisted entity
     */
    JhiResource save(JhiResource jhiResource);

    /**
     * Get all the jhiResources.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<JhiResource> findAll(Pageable pageable);


    /**
     * Get the "id" jhiResource.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JhiResource> findOne(Long id);

    /**
     * Delete the "id" jhiResource.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
