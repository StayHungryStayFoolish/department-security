package io.github.stayhungrystayfoolish.repository;

import io.github.stayhungrystayfoolish.domain.JhiPermission;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JhiPermission entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JhiPermissionRepository extends JpaRepository<JhiPermission, Long> {

}
