package io.github.stayhungrystayfoolish.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.stayhungrystayfoolish.domain.JhiAuthPermRes;
import io.github.stayhungrystayfoolish.service.JhiAuthPermResService;
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
 * REST controller for managing JhiAuthPermRes.
 */
@RestController
@RequestMapping("/api")
public class JhiAuthPermResResource {

    private final Logger log = LoggerFactory.getLogger(JhiAuthPermResResource.class);

    private static final String ENTITY_NAME = "jhiAuthPermRes";

    private final JhiAuthPermResService jhiAuthPermResService;

    public JhiAuthPermResResource(JhiAuthPermResService jhiAuthPermResService) {
        this.jhiAuthPermResService = jhiAuthPermResService;
    }

    /**
     * POST  /jhi-auth-perm-res : Create a new jhiAuthPermRes.
     *
     * @param jhiAuthPermRes the jhiAuthPermRes to create
     * @return the ResponseEntity with status 201 (Created) and with body the new jhiAuthPermRes, or with status 400 (Bad Request) if the jhiAuthPermRes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/jhi-auth-perm-res")
    @Timed
    public ResponseEntity<JhiAuthPermRes> createJhiAuthPermRes(@RequestBody JhiAuthPermRes jhiAuthPermRes) throws URISyntaxException {
        log.debug("REST request to save JhiAuthPermRes : {}", jhiAuthPermRes);
        if (jhiAuthPermRes.getId() != null) {
            throw new BadRequestAlertException("A new jhiAuthPermRes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JhiAuthPermRes result = jhiAuthPermResService.save(jhiAuthPermRes);
        return ResponseEntity.created(new URI("/api/jhi-auth-perm-res/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /jhi-auth-perm-res : Updates an existing jhiAuthPermRes.
     *
     * @param jhiAuthPermRes the jhiAuthPermRes to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated jhiAuthPermRes,
     * or with status 400 (Bad Request) if the jhiAuthPermRes is not valid,
     * or with status 500 (Internal Server Error) if the jhiAuthPermRes couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/jhi-auth-perm-res")
    @Timed
    public ResponseEntity<JhiAuthPermRes> updateJhiAuthPermRes(@RequestBody JhiAuthPermRes jhiAuthPermRes) throws URISyntaxException {
        log.debug("REST request to update JhiAuthPermRes : {}", jhiAuthPermRes);
        if (jhiAuthPermRes.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JhiAuthPermRes result = jhiAuthPermResService.save(jhiAuthPermRes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, jhiAuthPermRes.getId().toString()))
            .body(result);
    }

    /**
     * GET  /jhi-auth-perm-res : get all the jhiAuthPermRes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of jhiAuthPermRes in body
     */
    @GetMapping("/jhi-auth-perm-res")
    @Timed
    public ResponseEntity<List<JhiAuthPermRes>> getAllJhiAuthPermRes(Pageable pageable) {
        log.debug("REST request to get a page of JhiAuthPermRes");
        Page<JhiAuthPermRes> page = jhiAuthPermResService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/jhi-auth-perm-res");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /jhi-auth-perm-res/:id : get the "id" jhiAuthPermRes.
     *
     * @param id the id of the jhiAuthPermRes to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the jhiAuthPermRes, or with status 404 (Not Found)
     */
    @GetMapping("/jhi-auth-perm-res/{id}")
    @Timed
    public ResponseEntity<JhiAuthPermRes> getJhiAuthPermRes(@PathVariable Long id) {
        log.debug("REST request to get JhiAuthPermRes : {}", id);
        Optional<JhiAuthPermRes> jhiAuthPermRes = jhiAuthPermResService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jhiAuthPermRes);
    }

    /**
     * DELETE  /jhi-auth-perm-res/:id : delete the "id" jhiAuthPermRes.
     *
     * @param id the id of the jhiAuthPermRes to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/jhi-auth-perm-res/{id}")
    @Timed
    public ResponseEntity<Void> deleteJhiAuthPermRes(@PathVariable Long id) {
        log.debug("REST request to delete JhiAuthPermRes : {}", id);
        jhiAuthPermResService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
