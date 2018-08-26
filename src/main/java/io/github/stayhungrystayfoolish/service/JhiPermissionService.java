package io.github.stayhungrystayfoolish.service;

import io.github.stayhungrystayfoolish.domain.JhiPermission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing JhiPermission.
 */
public interface JhiPermissionService {

    /**
     * Save a jhiPermission.
     *
     * @param jhiPermission the entity to save
     * @return the persisted entity
     */
    JhiPermission save(JhiPermission jhiPermission);

    /**
     * Get all the jhiPermissions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<JhiPermission> findAll(Pageable pageable);


    /**
     * Get the "id" jhiPermission.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JhiPermission> findOne(Long id);

    /**
     * Delete the "id" jhiPermission.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
