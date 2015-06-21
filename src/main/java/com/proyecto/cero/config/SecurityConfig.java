package com.proyecto.cero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.proyecto.cero.signin.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.formLogin()
			.loginPage("/signupExtra")
//			.loginProcessingUrl("/signin/authenticate")
//			.failureUrl("/signin?param.error=bad_credentials")
			.and()
			.logout()
				.logoutUrl("/signout")
				.deleteCookies("JSESSIONID")
				.logoutSuccessHandler(new LogoutSuccessHandler("/signin"))
		.and()
			.authorizeRequests()
				.antMatchers("/vaquitaCreada").authenticated()
				.antMatchers("/**","/signin/**","/search**", "/googleMap**", "/resources/**", "/auth/**", "/signup/**", "/disconnect/facebook").permitAll()
		.and()
			.rememberMe()
		.and().csrf();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}