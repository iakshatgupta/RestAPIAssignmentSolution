package com.greatlearning.employeemanagementsystems.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagementsystems.service.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/api/employees").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.POST,"/api/user").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.POST,"/api/role").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.GET,"/api/employees/*").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.GET,"/api/employees/search/*").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.PUT, "/api/employees").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.DELETE, "/api/employees/*").hasAnyAuthority("ADMIN","USER")
				.antMatchers(HttpMethod.POST, "/api/employees").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().httpBasic()
				.and().cors().and().csrf().disable();
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

}
