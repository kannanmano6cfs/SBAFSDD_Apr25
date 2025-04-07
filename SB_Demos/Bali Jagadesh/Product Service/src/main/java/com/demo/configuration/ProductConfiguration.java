package com.demo.configuration;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

	
	/*  @Bean public UserDetailsService userDetailsService() { UserDetails
	  user=User.withDefaultPasswordEncoder() .username("Vivek")
	  .password("vivek@123") .roles("USER") .build(); UserDetails
	  admin=User.withDefaultPasswordEncoder() .username("Jagadeesh")
	  .password("Jagadeesh@123") .roles("ADMIN") .build(); return new
	  InMemoryUserDetailsManager(user,admin); }
	  
	 @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception {
	   http.authorizeHttpRequests((auth)->auth
                .requestMatchers(HttpMethod.POST,"/api/addProducts").hasAnyRole("USER","ADMIN")
               .requestMatchers("/api/getProducts/**").hasRole("ADMIN")
               .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
       return http.build();
	  
	  }
	 */

}
