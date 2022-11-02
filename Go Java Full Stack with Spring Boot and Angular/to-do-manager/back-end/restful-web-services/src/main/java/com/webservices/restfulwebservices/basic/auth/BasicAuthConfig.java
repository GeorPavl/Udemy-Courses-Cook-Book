package com.webservices.restfulwebservices.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class BasicAuthConfig {

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web
//                .ignoring()
//                .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
////                .antMatchers(HttpMethod.DELETE)
////                .hasRole("ADMIN")
////                .antMatchers("/admin/**")
////                .hasAnyRole("ADMIN")
////                .antMatchers("/user/**")
////                .hasAnyRole("USER", "ADMIN")
////                .antMatchers("/login/**")
////                .anonymous()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService)
//            throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailService)
//                .passwordEncoder(bCryptPasswordEncoder)
//                .and()
//                .build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("userPass"))
//                .roles("USER")
//                .build());
//        manager.createUser(User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("adminPass"))
//                .roles("USER", "ADMIN")
//                .build());
//        return manager;
//    }


}
