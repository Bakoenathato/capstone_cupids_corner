package za.ac.cput.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.domain.user.Role;
import za.ac.cput.domain.user.User;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails{

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //return Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().getAuthority()));


        /*
        @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = user.getRole().getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        return authorities;
    }

        * */

//        return Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole().name()));
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.getUserRole() == Role.USER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.USER.toString()));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.ADMIN.toString()));
        }
        //System.out.println(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
