package io.github.stayhungrystayfoolish.service.impl;

import io.github.stayhungrystayfoolish.service.JhiDepartmentService;
import io.github.stayhungrystayfoolish.domain.JhiDepartment;
import io.github.stayhungrystayfoolish.repository.JhiDepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing JhiDepartment.
 */
@Service
@Transactional
public class JhiDepartmentServiceImpl implements JhiDepartmentService {

    private final Logger log = LoggerFactory.getLogger(JhiDepartmentServiceImpl.class);

    private final JhiDepartmentRepository jhiDepartmentRepository;

    public JhiDepartmentServiceImpl(JhiDepartmentRepository jhiDepartmentRepository) {
        this.jhiDepartmentRepository = jhiDepartmentRepository;
    }

    /**
     * Save a jhiDepartment.
     *
     * @param jhiDepartment the entity to save
     * @return the persisted entity
     */
    @Override
    public JhiDepartment save(JhiDepartment jhiDepartment) {
        log.debug("Request to save JhiDepartment : {}", jhiDepartment);        return jhiDepartmentRepository.save(jhiDepartment);
    }

    /**
     * Get all the jhiDepartments.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<JhiDepartment> findAll() {
        log.debug("Request to get all JhiDepartments");
        return jhiDepartmentRepository.findAll();
    }


    /**
     * Get one jhiDepartment by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JhiDepartment> findOne(Long id) {
        log.debug("Request to get JhiDepartment : {}", id);
        return jhiDepartmentRepository.findById(id);
    }

    /**
     * Delete the jhiDepartment by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JhiDepartment : {}", id);
        jhiDepartmentRepository.deleteById(id);
    }
}
