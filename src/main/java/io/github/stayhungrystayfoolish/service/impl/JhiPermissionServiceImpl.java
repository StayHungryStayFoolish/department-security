package io.github.stayhungrystayfoolish.service.impl;

import io.github.stayhungrystayfoolish.service.JhiPermissionService;
import io.github.stayhungrystayfoolish.domain.JhiPermission;
import io.github.stayhungrystayfoolish.repository.JhiPermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing JhiPermission.
 */
@Service
@Transactional
public class JhiPermissionServiceImpl implements JhiPermissionService {

    private final Logger log = LoggerFactory.getLogger(JhiPermissionServiceImpl.class);

    private final JhiPermissionRepository jhiPermissionRepository;

    public JhiPermissionServiceImpl(JhiPermissionRepository jhiPermissionRepository) {
        this.jhiPermissionRepository = jhiPermissionRepository;
    }

    /**
     * Save a jhiPermission.
     *
     * @param jhiPermission the entity to save
     * @return the persisted entity
     */
    @Override
    public JhiPermission save(JhiPermission jhiPermission) {
        log.debug("Request to save JhiPermission : {}", jhiPermission);        return jhiPermissionRepository.save(jhiPermission);
    }

    /**
     * Get all the jhiPermissions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JhiPermission> findAll(Pageable pageable) {
        log.debug("Request to get all JhiPermissions");
        return jhiPermissionRepository.findAll(pageable);
    }


    /**
     * Get one jhiPermission by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JhiPermission> findOne(Long id) {
        log.debug("Request to get JhiPermission : {}", id);
        return jhiPermissionRepository.findById(id);
    }

    /**
     * Delete the jhiPermission by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JhiPermission : {}", id);
        jhiPermissionRepository.deleteById(id);
    }
}
