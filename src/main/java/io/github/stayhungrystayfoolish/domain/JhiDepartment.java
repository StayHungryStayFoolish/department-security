package io.github.stayhungrystayfoolish.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A JhiDepartment.
 */
@Entity
@Table(name = "jhi_department")
public class JhiDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @Column(name = "department_name")
    private String departmentName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "jhi_department_authority",
        joinColumns = {@JoinColumn(name = "department_name", referencedColumnName = "department_name")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getDepartmentName() {
        return departmentName;
    }

    public JhiDepartment departmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JhiDepartment department = (JhiDepartment) o;

        return !(departmentName != null ? !departmentName.equals(department.departmentName) : department.departmentName != null);

    }

    @Override
    public int hashCode() {
        return departmentName != null ? departmentName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JhiDepartment{" +
            ", departmentName='" + getDepartmentName() + "'" +
            "}";
    }
}
