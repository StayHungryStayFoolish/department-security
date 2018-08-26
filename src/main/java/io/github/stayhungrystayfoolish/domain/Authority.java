package io.github.stayhungrystayfoolish.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * An authority (a security role) used by Spring Security.
 */
@Entity
@Table(name = "jhi_authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 50)
    @Id
    @Column(length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @OneToMany(mappedBy = "jhiAuthority", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<JhiAuthPermRes> authorities = new HashSet<>();


    public Authority name(String name) {
        this.name = name;
        return this;
    }

    public Authority authorities(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.authorities = jhiAuthPermRes;
        return this;
    }


    public Authority addAuthority(JhiAuthPermRes jhiAuthPermRes) {
        this.authorities.add(jhiAuthPermRes);
        jhiAuthPermRes.setJhiAuthority(this);
        return this;
    }

    public Authority removeAuthority(JhiAuthPermRes jhiAuthorityPermissionResource) {
        this.authorities.remove(jhiAuthorityPermissionResource);
        jhiAuthorityPermissionResource.setJhiAuthority(null);
        return this;
    }

    public Set<JhiAuthPermRes> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<JhiAuthPermRes> jhiAuthPermRes) {
        this.authorities = jhiAuthPermRes;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authority authority = (Authority) o;

        return !(name != null ? !name.equals(authority.name) : authority.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Authority{" +
            "name='" + name + '\'' +
            "}";
    }
}
