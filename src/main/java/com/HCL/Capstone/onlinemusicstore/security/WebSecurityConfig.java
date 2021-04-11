package com.HCL.Capstone.onlinemusicstore.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.HCL.Capstone.onlinemusicstore.entity.Product;
import com.HCL.Capstone.onlinemusicstore.entity.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//.antMatchers("/**").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/account").hasAnyRole("USER", "ADMIN").and().formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true").permitAll()
				.successHandler(new SavedRequestAwareAuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication auth) throws IOException, ServletException {
						MyUserDetails userDetails = (MyUserDetails) auth.getPrincipal();
						User user = userDetails.getUser();
						
						if(user.getRole().equals("ROLE_ADMIN")) {
							request.getSession().setAttribute("admin", user);
						}
						request.getSession().setAttribute("user", user);
						request.getSession().setAttribute("cart", new ArrayList<Product>());
						super.onAuthenticationSuccess(request, response, auth);
					}
				})
				.and().logout().logoutUrl("/logout").invalidateHttpSession(true).permitAll()
				.and().exceptionHandling().accessDeniedPage("/denied");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
