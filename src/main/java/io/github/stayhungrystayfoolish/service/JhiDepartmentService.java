package io.github.stayhungrystayfoolish.service;

import io.github.stayhungrystayfoolish.domain.JhiDepartment;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing JhiDepartment.
 */
public interface JhiDepartmentService {

    /**
     * Save a jhiDepartment.
     *
     * @param jhiDepartment the entity to save
     * @return the persisted entity
     */
    JhiDepartment save(JhiDepartment jhiDepartment);

    /**
     * Get all the jhiDepartments.
     *
     * @return the list of entities
     */
    List<JhiDepartment> findAll();


    /**
     * Get the "id" jhiDepartment.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JhiDepartment> findOne(Long id);

    /**
     * Delete the "id" jhiDepartment.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
