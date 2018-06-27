package org.pi.config;

import org.pi.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests()
		.antMatchers("/resources/**", "/js/**","/static/**", "/css/**", "/js/**", "/img/**","/scss/**","/fonts/**","/").permitAll()
		.and().authorizeRequests().antMatchers("/**/supprimer","/**/refuser","/**/accepter").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/").permitAll()
		   .usernameParameter("email").passwordParameter("password").loginProcessingUrl("/connect").defaultSuccessUrl("/inventaire")
		   .and()
		    .logout().logoutSuccessUrl("/login?logout")
		    .and()
		    .exceptionHandling().accessDeniedPage("/403");
//				

	}

}