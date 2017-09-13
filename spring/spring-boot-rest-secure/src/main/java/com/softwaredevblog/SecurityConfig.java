package com.softwaredevblog;

import com.softwaredevblog.service.RestUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected UserDetailsService userDetailsService() {
        return new RestUserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/movie/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/movie/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/movie/**").hasRole("ADMIN")
                .and().csrf().disable();
    }
}
