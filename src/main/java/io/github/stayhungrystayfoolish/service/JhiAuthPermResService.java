package io.github.stayhungrystayfoolish.service;

import io.github.stayhungrystayfoolish.domain.JhiAuthPermRes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing JhiAuthPermRes.
 */
public interface JhiAuthPermResService {

    /**
     * Save a jhiAuthPermRes.
     *
     * @param jhiAuthPermRes the entity to save
     * @return the persisted entity
     */
    JhiAuthPermRes save(JhiAuthPermRes jhiAuthPermRes);

    /**
     * Get all the jhiAuthPermRes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<JhiAuthPermRes> findAll(Pageable pageable);


    /**
     * Get the "id" jhiAuthPermRes.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JhiAuthPermRes> findOne(Long id);

    /**
     * Delete the "id" jhiAuthPermRes.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
