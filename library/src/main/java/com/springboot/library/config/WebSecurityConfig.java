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
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home").hasAnyRole("ADMIN","STUDENT")
                .antMatchers("/studentDashboard").hasRole("STUDENT")
                .antMatchers("/adminDashboard").hasRole("ADMIN")
                .antMatchers("/student/deletebook").hasRole("STUDENT")
                .antMatchers("/student/addbooktostudent").hasRole("STUDENT")
                .antMatchers("/admin/studentlist").hasRole("ADMIN")
                .antMatchers("/admin/booklist").hasRole("ADMIN")
                .antMatchers("/admin/userlist").hasRole("ADMIN")
                .antMatchers("/admin/addstudent").hasRole("ADMIN")
                .antMatchers("/admin/addbook").hasRole("ADMIN")
                .antMatchers("/admin/showStudentFormForUpdate").hasRole("ADMIN")
                .antMatchers("/admin/showBookFormForUpdate").hasRole("ADMIN")
                .antMatchers("/admin/showUserFormForUpdate").hasRole("ADMIN")
                .antMatchers("/admin/savestudent").hasRole("ADMIN")
                .antMatchers("/admin/savebook").hasRole("ADMIN")
                .antMatchers("/admin/saveuser").hasRole("ADMIN")
                .antMatchers("/admin/deletestudent").hasRole("ADMIN")
                .antMatchers("/admin/deletebook").hasRole("ADMIN")
                .antMatchers("/admin/deleteuser").hasRole("ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/student/**").hasRole("STUDENT")
                .anyRequest()
                .authenticated()
                .and()
//                .formLogin(
//                        form -> form
////                                .defaultSuccessUrl("/home")
//                                .loginProcessingUrl("authenticateTheUser")
//                                .successHandler(successHandler)
//                                .failureUrl("/login?error=true")
//                                .permitAll()
//                )
                .formLogin()
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(successHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
