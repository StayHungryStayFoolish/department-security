package io.github.stayhungrystayfoolish.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.stayhungrystayfoolish.domain.JhiDepartment;
import io.github.stayhungrystayfoolish.service.JhiDepartmentService;
import io.github.stayhungrystayfoolish.web.rest.errors.BadRequestAlertException;
import io.github.stayhungrystayfoolish.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing JhiDepartment.
 */
@RestController
@RequestMapping("/api")
public class JhiDepartmentResource {

    private final Logger log = LoggerFactory.getLogger(JhiDepartmentResource.class);

    private static final String ENTITY_NAME = "jhiDepartment";

    private final JhiDepartmentService jhiDepartmentService;

    public JhiDepartmentResource(JhiDepartmentService jhiDepartmentService) {
        this.jhiDepartmentService = jhiDepartmentService;
    }

    /**
     * POST  /jhi-departments : Create a new jhiDepartment.
     *
     * @param jhiDepartment the jhiDepartment to create
     * @return the ResponseEntity with status 201 (Created) and with body the new jhiDepartment, or with status 400 (Bad Request) if the jhiDepartment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/jhi-departments")
    @Timed
    public ResponseEntity<JhiDepartment> createJhiDepartment(@RequestBody JhiDepartment jhiDepartment) throws URISyntaxException {
        log.debug("REST request to save JhiDepartment : {}", jhiDepartment);
        JhiDepartment result = jhiDepartmentService.save(jhiDepartment);
        return ResponseEntity.ok(result);
    }

    /**
     * PUT  /jhi-departments : Updates an existing jhiDepartment.
     *
     * @param jhiDepartment the jhiDepartment to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated jhiDepartment,
     * or with status 400 (Bad Request) if the jhiDepartment is not valid,
     * or with status 500 (Internal Server Error) if the jhiDepartment couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/jhi-departments")
    @Timed
    public ResponseEntity<JhiDepartment> updateJhiDepartment(@RequestBody JhiDepartment jhiDepartment) throws URISyntaxException {
        log.debug("REST request to update JhiDepartment : {}", jhiDepartment);
        JhiDepartment result = jhiDepartmentService.save(jhiDepartment);
        return ResponseEntity.ok().body(result);
    }

    /**
     * GET  /jhi-departments : get all the jhiDepartments.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of jhiDepartments in body
     */
    @GetMapping("/jhi-departments")
    @Timed
    public List<JhiDepartment> getAllJhiDepartments() {
        log.debug("REST request to get all JhiDepartments");
        return jhiDepartmentService.findAll();
    }

    /**
     * GET  /jhi-departments/:id : get the "id" jhiDepartment.
     *
     * @param id the id of the jhiDepartment to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the jhiDepartment, or with status 404 (Not Found)
     */
    @GetMapping("/jhi-departments/{id}")
    @Timed
    public ResponseEntity<JhiDepartment> getJhiDepartment(@PathVariable Long id) {
        log.debug("REST request to get JhiDepartment : {}", id);
        Optional<JhiDepartment> jhiDepartment = jhiDepartmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jhiDepartment);
    }

    /**
     * DELETE  /jhi-departments/:id : delete the "id" jhiDepartment.
     *
     * @param id the id of the jhiDepartment to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/jhi-departments/{id}")
    @Timed
    public ResponseEntity<Void> deleteJhiDepartment(@PathVariable Long id) {
        log.debug("REST request to delete JhiDepartment : {}", id);
        jhiDepartmentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
