package com.Ecomercial.CTTT2018.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(100)
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//Homepage
				.antMatchers("/").permitAll()
				.antMatchers("/register").permitAll()
				//Static Resource
				//TODO Add Pages that can be visited without authentication.
				.antMatchers("/css/**", "/images/**", "/js/**", "/bootstrap/**").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated() // Ask for authentication on every request except filtered
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.deleteCookies("remember-me")
				.logoutSuccessUrl("/")
				.permitAll()
				.and()
				.rememberMe();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
	}

}