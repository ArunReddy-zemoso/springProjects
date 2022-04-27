package com.springboot.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationSuccessHandler successHandler;
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
     AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        String password="arun";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("Encoded Password is : " + encodedPassword);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").hasAnyRole("ADMIN","STUDENT")
                .antMatchers("/books/showFormForAdd").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(successHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
