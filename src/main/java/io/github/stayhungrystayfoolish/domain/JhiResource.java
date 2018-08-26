package io.github.stayhungrystayfoolish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A JhiResource.
 */
@Entity
@Table(name = "jhi_resource")
public class JhiResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name")
    private String resourceName;

    @OneToMany(mappedBy = "jhiResource")
    private Set<JhiAuthPermRes> resources = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public JhiResource resourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Set<JhiAuthPermRes> getResources() {
        return resources;
    }

    public JhiResource resources(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.resources = jhiAuthPermRes;
        return this;
    }

    public JhiResource addResources(JhiAuthPermRes jhiAuthPermRes) {
        this.resources.add(jhiAuthPermRes);
        jhiAuthPermRes.setJhiResource(this);
        return this;
    }

    public JhiResource removeResources(JhiAuthPermRes jhiAuthPermRes) {
        this.resources.remove(jhiAuthPermRes);
        jhiAuthPermRes.setJhiResource(null);
        return this;
    }

    public void setResources(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.resources = jhiAuthPermRes;
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
        JhiResource jhiResource = (JhiResource) o;
        if (jhiResource.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jhiResource.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JhiResource{" +
            "id=" + getId() +
            ", resourceName='" + getResourceName() + "'" +
            "}";
    }
}
