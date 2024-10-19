package za.ac.cput.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER;

    /*
    * ADMIN_CREATE
    * ADMIN_READ
    * ADMIN_GET
    * ADMIN_POST
    *
    * USER_CREATE
    * */

    @Override
    public String getAuthority() {
        return name();
    }
}
