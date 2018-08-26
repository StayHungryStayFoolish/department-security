package io.github.stayhungrystayfoolish.repository;

import io.github.stayhungrystayfoolish.domain.JhiResource;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JhiResource entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JhiResourceRepository extends JpaRepository<JhiResource, Long> {

}
