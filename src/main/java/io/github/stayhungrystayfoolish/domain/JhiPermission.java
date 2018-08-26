package io.github.stayhungrystayfoolish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A JhiPermission.
 */
@Entity
@Table(name = "jhi_permission")
public class JhiPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;

    @OneToMany(mappedBy = "jhiPermission")
    private Set<JhiAuthPermRes> permissions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public JhiPermission permissionName(String permissionName) {
        this.permissionName = permissionName;
        return this;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Set<JhiAuthPermRes> getPermissions() {
        return permissions;
    }

    public JhiPermission permissions(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.permissions = jhiAuthPermRes;
        return this;
    }

    public JhiPermission addPermission(JhiAuthPermRes jhiAuthPermRes) {
        this.permissions.add(jhiAuthPermRes);
        jhiAuthPermRes.setJhiPermission(this);
        return this;
    }

    public JhiPermission removePermission(JhiAuthPermRes jhiAuthPermRes) {
        this.permissions.remove(jhiAuthPermRes);
        jhiAuthPermRes.setJhiPermission(null);
        return this;
    }

    public void setPermissions(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.permissions = jhiAuthPermRes;
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
        JhiPermission jhiPermission = (JhiPermission) o;
        if (jhiPermission.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jhiPermission.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JhiPermission{" +
            "id=" + getId() +
            ", permissionName='" + getPermissionName() + "'" +
            "}";
    }
}
