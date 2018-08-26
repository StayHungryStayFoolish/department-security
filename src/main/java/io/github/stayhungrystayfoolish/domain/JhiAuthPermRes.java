package io.github.stayhungrystayfoolish.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A JhiAuthPermRes.
 */
@Entity
@Table(name = "jhi_auth_perm_res")
public class JhiAuthPermRes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority_name")
    private String authorityName;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "resource_name")
    private String resourceName;

    @ManyToOne
    @JsonIgnoreProperties("permissions")
    private JhiPermission jhiPermission;

    @ManyToOne
    @JsonIgnoreProperties("resources")
    private JhiResource jhiResource;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @ManyToOne
    @JsonIgnoreProperties("authorities")
    private Authority jhiAuthority;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public JhiAuthPermRes authorityName(String authorityName) {
        this.authorityName = authorityName;
        return this;
    }

    public JhiAuthPermRes jhiAuthority(Authority jhiAuthority) {
        this.jhiAuthority = jhiAuthority;
        return this;
    }

    public void setJhiAuthority(Authority jhiAuthority) {
        this.jhiAuthority = jhiAuthority;
    }

    public Authority getJhiAuthority() {
        return jhiAuthority;
    }

    public void setAuthority(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public JhiAuthPermRes permissionName(String permissionName) {
        this.permissionName = permissionName;
        return this;
    }

    public JhiAuthPermRes jhiPermission(JhiPermission jhiPermission) {
        this.jhiPermission = jhiPermission;
        return this;
    }

    public void setJhiPermission(JhiPermission jhiPermission) {
        this.jhiPermission = jhiPermission;
    }


    public JhiPermission getJhiPermission() {
        return jhiPermission;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public JhiAuthPermRes resourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public JhiAuthPermRes jhiResource(JhiResource jhiResource) {
        this.jhiResource = jhiResource;
        return this;
    }

    public void setJhiResource(JhiResource jhiResource) {
        this.jhiResource = jhiResource;
    }

    public JhiResource getJhiResource() {
        return jhiResource;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
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
        JhiAuthPermRes jhiAuthPermRes = (JhiAuthPermRes) o;
        if (jhiAuthPermRes.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jhiAuthPermRes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JhiAuthPermRes{" +
            "id=" + getId() +
            ", authorityName='" + getAuthorityName() + "'" +
            ", permissionName='" + getPermissionName() + "'" +
            ", resourceName='" + getResourceName() + "'" +
            "}";
    }
}
