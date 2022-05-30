package com.nhnacademy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/private-project/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                .antMatchers("/project/**").authenticated()
                .antMatchers("/redirect-index").authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .and()
            .logout()
                .and()
            .csrf()
                .disable()
            .sessionManagement()
                .sessionFixation()
                    .none()
                .and()
                .headers()
                .defaultsDisabled()
                .httpStrictTransportSecurity()
                .requestMatcher(new AndRequestMatcher())
                .maxAgeInSeconds(31536000)
                .includeSubDomains(true)
                .and()
                .and()
                .requiresChannel()
                .antMatchers("/admin/**").requiresSecure();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
                .password("{noop}admin")
                .authorities("ROLE_ADMIN")
                .and()
            .withUser("member")
                .password("{noop}member")
                .authorities("ROLE_MEMBER")
                .and()
            .withUser("guest")
                .password("{noop}guest")
                .authorities("ROLE_GUEST");
    }

}
