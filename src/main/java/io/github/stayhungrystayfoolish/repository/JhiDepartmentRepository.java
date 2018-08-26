package io.github.stayhungrystayfoolish.repository;

import io.github.stayhungrystayfoolish.domain.JhiDepartment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JhiDepartment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JhiDepartmentRepository extends JpaRepository<JhiDepartment, Long> {

    JhiDepartment findByDepartmentName(String departmentName);
}

