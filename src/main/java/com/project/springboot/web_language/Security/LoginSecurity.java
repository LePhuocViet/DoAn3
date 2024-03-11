package com.project.springboot.web_language.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class LoginSecurity {

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager((dataSource));

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select MATK , MATKHAU, active from taikhoan where MATK=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select MATK,TENPHANQUYEN from phanquyen where MATK=?"
        );
        return jdbcUserDetailsManager;

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/Setting").hasRole("MEMBER")
                                .requestMatchers("/Home","/Login","/Logout").permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin(form ->
                        form
                                .loginPage("/Login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }

}
