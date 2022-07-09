package com.anup.springbootsecuritymysqltutorial.models;

import com.anup.springbootsecuritymysqltutorial.entity.User;
import com.anup.springbootsecuritymysqltutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyUserDetailsJPA implements UserDetails {

    private String userName;
    private String password;
    private String active;
    private List<GrantedAuthority> authorities;


    public MyUserDetailsJPA() {
    }

    public MyUserDetailsJPA(Optional<User> user) {
        this.userName = user.get().getUserName();
        this.password = user.get().getPassword();
        this.active = user.get().getActive();
        this.authorities = Arrays.stream(user.get().getRoles().split(",")).map(e ->e.strip())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        authorities.stream().forEach(System.out::println);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
