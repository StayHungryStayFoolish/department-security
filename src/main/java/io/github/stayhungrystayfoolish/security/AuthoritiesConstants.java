package io.github.stayhungrystayfoolish.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String DEP_ADMIN_NAME = "ROLE_DEP_ADMIN";
    public static final String DEP_USER_NAME = "ROLE_DEP_COMMON";
    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}
