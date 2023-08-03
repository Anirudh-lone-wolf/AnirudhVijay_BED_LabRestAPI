package com.glearning.LabSixDebateEvent.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.glearning.LabSixDebateEvent.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/studentdetails/save").hasAnyAuthority("USER", "ADMIN")
				.antMatchers("/studentdetails", "/studentdetails/list", "/studentdetails/showFormForAdd",
						"/studentdetails/403")
				.hasAnyAuthority("USER", "ADMIN")
				.antMatchers("/studentdetails/showFormForUpdate", "/studentdetails/delete").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/studentdetails/list").permitAll().and().logout().logoutSuccessUrl("/login")
				.permitAll().and().exceptionHandling().accessDeniedPage("/studentdetails/403").and().cors().and().csrf()
				.disable();

		http.authenticationProvider(authenticationProvider());
		
		return http.build();

	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;

	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
