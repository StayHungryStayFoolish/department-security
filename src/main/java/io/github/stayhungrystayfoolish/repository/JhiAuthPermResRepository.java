package io.github.stayhungrystayfoolish.repository;

import io.github.stayhungrystayfoolish.domain.JhiAuthPermRes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JhiAuthPermRes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JhiAuthPermResRepository extends JpaRepository<JhiAuthPermRes, Long> {

}
