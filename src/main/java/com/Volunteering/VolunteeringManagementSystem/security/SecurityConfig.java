//package com.Volunteering.VolunteeringManagementSystem.security;
//
//import com.Volunteering.VolunteeringManagementSystem.filters.CustomAuthenticationFilter;
//import com.Volunteering.VolunteeringManagementSystem.filters.CustomAuthorizationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
//    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
//        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManager());
//        filter.setFilterProcessesUrl("/login");
//        return filter;
//    }
//
//    @Bean
//    public CustomAuthorizationFilter customAuthorizationFilter() {
//        return new CustomAuthorizationFilter();
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(customAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/login").permitAll()
//                .antMatchers("/managers/**").hasRole("MANAGER")
//                .antMatchers("/volunteers/**").hasRole("VOLUNTEER")
//                .anyRequest().authenticated();
//    }
//}
