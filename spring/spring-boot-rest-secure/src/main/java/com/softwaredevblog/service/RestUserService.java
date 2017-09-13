package com.softwaredevblog.service;

import com.softwaredevblog.entities.RestUser;
import com.softwaredevblog.repository.RestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestUserService implements UserDetailsService {
    @Autowired
    private RestUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestUser user = userRepository.findByUsername(username);
        if (user != null) {
            return new User(user.getUsername(), user.getPassword(), createAuthorityList(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("User: "
                    + username + " not found");
        }
    }

    public List<GrantedAuthority> createAuthorityList(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}
