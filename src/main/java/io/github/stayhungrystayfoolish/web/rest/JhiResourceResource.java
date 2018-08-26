package io.github.stayhungrystayfoolish.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.stayhungrystayfoolish.domain.JhiResource;
import io.github.stayhungrystayfoolish.service.JhiResourceService;
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
 * REST controller for managing JhiResource.
 */
@RestController
@RequestMapping("/api")
public class JhiResourceResource {

    private final Logger log = LoggerFactory.getLogger(JhiResourceResource.class);

    private static final String ENTITY_NAME = "jhiResource";

    private final JhiResourceService jhiResourceService;

    public JhiResourceResource(JhiResourceService jhiResourceService) {
        this.jhiResourceService = jhiResourceService;
    }

    /**
     * POST  /jhi-resources : Create a new jhiResource.
     *
     * @param jhiResource the jhiResource to create
     * @return the ResponseEntity with status 201 (Created) and with body the new jhiResource, or with status 400 (Bad Request) if the jhiResource has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/jhi-resources")
    @Timed
    public ResponseEntity<JhiResource> createJhiResource(@RequestBody JhiResource jhiResource) throws URISyntaxException {
        log.debug("REST request to save JhiResource : {}", jhiResource);
        if (jhiResource.getId() != null) {
            throw new BadRequestAlertException("A new jhiResource cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JhiResource result = jhiResourceService.save(jhiResource);
        return ResponseEntity.created(new URI("/api/jhi-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /jhi-resources : Updates an existing jhiResource.
     *
     * @param jhiResource the jhiResource to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated jhiResource,
     * or with status 400 (Bad Request) if the jhiResource is not valid,
     * or with status 500 (Internal Server Error) if the jhiResource couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/jhi-resources")
    @Timed
    public ResponseEntity<JhiResource> updateJhiResource(@RequestBody JhiResource jhiResource) throws URISyntaxException {
        log.debug("REST request to update JhiResource : {}", jhiResource);
        if (jhiResource.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JhiResource result = jhiResourceService.save(jhiResource);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, jhiResource.getId().toString()))
            .body(result);
    }

    /**
     * GET  /jhi-resources : get all the jhiResources.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of jhiResources in body
     */
    @GetMapping("/jhi-resources")
    @Timed
    public ResponseEntity<List<JhiResource>> getAllJhiResources(Pageable pageable) {
        log.debug("REST request to get a page of JhiResources");
        Page<JhiResource> page = jhiResourceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/jhi-resources");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /jhi-resources/:id : get the "id" jhiResource.
     *
     * @param id the id of the jhiResource to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the jhiResource, or with status 404 (Not Found)
     */
    @GetMapping("/jhi-resources/{id}")
    @Timed
    public ResponseEntity<JhiResource> getJhiResource(@PathVariable Long id) {
        log.debug("REST request to get JhiResource : {}", id);
        Optional<JhiResource> jhiResource = jhiResourceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jhiResource);
    }

    /**
     * DELETE  /jhi-resources/:id : delete the "id" jhiResource.
     *
     * @param id the id of the jhiResource to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/jhi-resources/{id}")
    @Timed
    public ResponseEntity<Void> deleteJhiResource(@PathVariable Long id) {
        log.debug("REST request to delete JhiResource : {}", id);
        jhiResourceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
