package com.sg.ls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sg.ls.handler.LoginFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
				.authorizeHttpRequests((auth) -> auth
						.requestMatchers("/videos/**", "/", "/login", "/loginProc", "/join", "/joinProc").permitAll()
						.requestMatchers("/admin").hasRole("ADMIN")
						.requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
						.anyRequest().authenticated()
				);
		
		http
				.formLogin((auth) -> auth.loginPage("/login")
						.loginProcessingUrl("/loginProc")
						.failureHandler(loginFailHandler())
						.defaultSuccessUrl("/dashboard")
						.permitAll()
				);
		
		http
				.csrf((auth) -> auth.disable());
		
		
		http
				.sessionManagement((auth) -> auth
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true));
		
		http	.sessionManagement((auth) -> auth
					.sessionFixation().changeSessionId());
		
		return http.build();
	}
	
	@Bean
    public LoginFailureHandler loginFailHandler(){
        return new LoginFailureHandler();
    }
}

