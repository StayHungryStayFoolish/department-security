package io.github.stayhungrystayfoolish.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.stayhungrystayfoolish.domain.JhiPermission;
import io.github.stayhungrystayfoolish.service.JhiPermissionService;
import io.github.stayhungrystayfoolish.web.rest.errors.BadRequestAlertException;
import io.github.stayhungrystayfoolish.web.rest.util.HeaderUtil;
import io.github.stayhungrystayfoolish.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing JhiPermission.
 */
@RestController
@RequestMapping("/api")
public class JhiPermissionResource {

    private final Logger log = LoggerFactory.getLogger(JhiPermissionResource.class);

    private static final String ENTITY_NAME = "jhiPermission";

    private final JhiPermissionService jhiPermissionService;

    public JhiPermissionResource(JhiPermissionService jhiPermissionService) {
        this.jhiPermissionService = jhiPermissionService;
    }

    /**
     * POST  /jhi-permissions : Create a new jhiPermission.
     *
     * @param jhiPermission the jhiPermission to create
     * @return the ResponseEntity with status 201 (Created) and with body the new jhiPermission, or with status 400 (Bad Request) if the jhiPermission has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/jhi-permissions")
    @Timed
    public ResponseEntity<JhiPermission> createJhiPermission(@RequestBody JhiPermission jhiPermission) throws URISyntaxException {
        log.debug("REST request to save JhiPermission : {}", jhiPermission);
        if (jhiPermission.getId() != null) {
            throw new BadRequestAlertException("A new jhiPermission cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JhiPermission result = jhiPermissionService.save(jhiPermission);
        return ResponseEntity.created(new URI("/api/jhi-permissions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /jhi-permissions : Updates an existing jhiPermission.
     *
     * @param jhiPermission the jhiPermission to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated jhiPermission,
     * or with status 400 (Bad Request) if the jhiPermission is not valid,
     * or with status 500 (Internal Server Error) if the jhiPermission couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/jhi-permissions")
    @Timed
    public ResponseEntity<JhiPermission> updateJhiPermission(@RequestBody JhiPermission jhiPermission) throws URISyntaxException {
        log.debug("REST request to update JhiPermission : {}", jhiPermission);
        if (jhiPermission.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JhiPermission result = jhiPermissionService.save(jhiPermission);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, jhiPermission.getId().toString()))
            .body(result);
    }

    /**
     * GET  /jhi-permissions : get all the jhiPermissions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of jhiPermissions in body
     */
    @GetMapping("/jhi-permissions")
    @Timed
    public ResponseEntity<List<JhiPermission>> getAllJhiPermissions(Pageable pageable) {
        log.debug("REST request to get a page of JhiPermissions");
        Page<JhiPermission> page = jhiPermissionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/jhi-permissions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /jhi-permissions/:id : get the "id" jhiPermission.
     *
     * @param id the id of the jhiPermission to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the jhiPermission, or with status 404 (Not Found)
     */
    @GetMapping("/jhi-permissions/{id}")
    @Timed
    public ResponseEntity<JhiPermission> getJhiPermission(@PathVariable Long id) {
        log.debug("REST request to get JhiPermission : {}", id);
        Optional<JhiPermission> jhiPermission = jhiPermissionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jhiPermission);
    }

    /**
     * DELETE  /jhi-permissions/:id : delete the "id" jhiPermission.
     *
     * @param id the id of the jhiPermission to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/jhi-permissions/{id}")
    @Timed
    public ResponseEntity<Void> deleteJhiPermission(@PathVariable Long id) {
        log.debug("REST request to delete JhiPermission : {}", id);
        jhiPermissionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
