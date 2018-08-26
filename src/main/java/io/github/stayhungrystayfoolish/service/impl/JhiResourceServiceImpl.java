package io.github.stayhungrystayfoolish.service.impl;

import io.github.stayhungrystayfoolish.service.JhiResourceService;
import io.github.stayhungrystayfoolish.domain.JhiResource;
import io.github.stayhungrystayfoolish.repository.JhiResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing JhiResource.
 */
@Service
@Transactional
public class JhiResourceServiceImpl implements JhiResourceService {

    private final Logger log = LoggerFactory.getLogger(JhiResourceServiceImpl.class);

    private final JhiResourceRepository jhiResourceRepository;

    public JhiResourceServiceImpl(JhiResourceRepository jhiResourceRepository) {
        this.jhiResourceRepository = jhiResourceRepository;
    }

    /**
     * Save a jhiResource.
     *
     * @param jhiResource the entity to save
     * @return the persisted entity
     */
    @Override
    public JhiResource save(JhiResource jhiResource) {
        log.debug("Request to save JhiResource : {}", jhiResource);        return jhiResourceRepository.save(jhiResource);
    }

    /**
     * Get all the jhiResources.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JhiResource> findAll(Pageable pageable) {
        log.debug("Request to get all JhiResources");
        return jhiResourceRepository.findAll(pageable);
    }


    /**
     * Get one jhiResource by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JhiResource> findOne(Long id) {
        log.debug("Request to get JhiResource : {}", id);
        return jhiResourceRepository.findById(id);
    }

    /**
     * Delete the jhiResource by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JhiResource : {}", id);
        jhiResourceRepository.deleteById(id);
    }
}
