package io.github.stayhungrystayfoolish.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A ExUser.
 */
@Entity
@Table(name = "ex_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ExUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "avatar_address")
    private String avatarAddress;

    @Lob
    @Column(name = "avatar_addr_name")
    private String avatarAddrName;

    @Column(name = "jhi_password")
    private String password;

    @Column(name = "jhi_level")
    private Integer level;

    @Column(name = "mat_id")
    private Long matId;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @Column(name = "last_login_time")
    private ZonedDateTime lastLoginTime;

    @Column(name = "last_ip")
    private String lastIp;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ExUser name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public ExUser avatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
        return this;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getAvatarAddrName() {
        return avatarAddrName;
    }

    public ExUser avatarAddrName(String avatarAddrName) {
        this.avatarAddrName = avatarAddrName;
        return this;
    }

    public void setAvatarAddrName(String avatarAddrName) {
        this.avatarAddrName = avatarAddrName;
    }

    public String getPassword() {
        return password;
    }

    public ExUser password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public ExUser level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getMatId() {
        return matId;
    }

    public ExUser matId(Long matId) {
        this.matId = matId;
        return this;
    }

    public void setMatId(Long matId) {
        this.matId = matId;
    }

    public String getEmail() {
        return email;
    }

    public ExUser email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public ExUser telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public ExUser userStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public ZonedDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public ExUser lastLoginTime(ZonedDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public void setLastLoginTime(ZonedDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public ExUser lastIp(String lastIp) {
        this.lastIp = lastIp;
        return this;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ExUser createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ExUser updatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
        ExUser exUser = (ExUser) o;
        if (exUser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExUser{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", avatarAddress='" + getAvatarAddress() + "'" +
            ", avatarAddrName='" + getAvatarAddrName() + "'" +
            ", password='" + getPassword() + "'" +
            ", level=" + getLevel() +
            ", matId=" + getMatId() +
            ", email='" + getEmail() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", userStatus='" + getUserStatus() + "'" +
            ", lastLoginTime='" + getLastLoginTime() + "'" +
            ", lastIp='" + getLastIp() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}

enum UserStatus {
    AVAILABLE, FROZEN
}
