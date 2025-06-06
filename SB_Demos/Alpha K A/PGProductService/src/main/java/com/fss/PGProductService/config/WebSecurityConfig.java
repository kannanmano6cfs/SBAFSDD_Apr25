package com.fss.PGProductService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

 import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {



    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((auth)->auth
//                .anyRequest().permitAll()
//                //.requestMatchers("/api/**").permitAll()
////                .requestMatchers(HttpMethod.POST,"/api/addproduct").hasAnyRole("USER","ADMIN")
////                .requestMatchers("/api/getproduct2/**").hasRole("ADMIN")
////                .requestMatchers("/api/deleteproduct/**").hasRole("ADMIN")
//        //        .anyRequest().authenticated()
//        ).httpBasic(Customizer.withDefaults());
//        return http.build();
        http
                .csrf(csrf -> csrf.disable()) // 🔥 Disable CSRF for API requests
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Allow all requests
                )
                .httpBasic(Customizer.withDefaults()); // Basic Auth (optional)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user= User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
