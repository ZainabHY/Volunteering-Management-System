package com.Volunteering.VolunteeringManagementSystem.security;
import com.Volunteering.VolunteeringManagementSystem.service.implementations.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class ManagerSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    private ManagerServiceImpl managerService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(managerService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/managers/**").hasRole("MANAGER")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
//}
