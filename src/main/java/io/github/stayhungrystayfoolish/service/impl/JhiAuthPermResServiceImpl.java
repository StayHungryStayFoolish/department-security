package io.github.stayhungrystayfoolish.service.impl;

import io.github.stayhungrystayfoolish.service.JhiAuthPermResService;
import io.github.stayhungrystayfoolish.domain.JhiAuthPermRes;
import io.github.stayhungrystayfoolish.repository.JhiAuthPermResRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing JhiAuthPermRes.
 */
@Service
@Transactional
public class JhiAuthPermResServiceImpl implements JhiAuthPermResService {

    private final Logger log = LoggerFactory.getLogger(JhiAuthPermResServiceImpl.class);

    private final JhiAuthPermResRepository jhiAuthPermResRepository;

    public JhiAuthPermResServiceImpl(JhiAuthPermResRepository jhiAuthPermResRepository) {
        this.jhiAuthPermResRepository = jhiAuthPermResRepository;
    }

    /**
     * Save a jhiAuthPermRes.
     *
     * @param jhiAuthPermRes the entity to save
     * @return the persisted entity
     */
    @Override
    public JhiAuthPermRes save(JhiAuthPermRes jhiAuthPermRes) {
        log.debug("Request to save JhiAuthPermRes : {}", jhiAuthPermRes);        return jhiAuthPermResRepository.save(jhiAuthPermRes);
    }

    /**
     * Get all the jhiAuthPermRes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JhiAuthPermRes> findAll(Pageable pageable) {
        log.debug("Request to get all JhiAuthPermRes");
        return jhiAuthPermResRepository.findAll(pageable);
    }


    /**
     * Get one jhiAuthPermRes by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JhiAuthPermRes> findOne(Long id) {
        log.debug("Request to get JhiAuthPermRes : {}", id);
        return jhiAuthPermResRepository.findById(id);
    }

    /**
     * Delete the jhiAuthPermRes by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JhiAuthPermRes : {}", id);
        jhiAuthPermResRepository.deleteById(id);
    }
}
