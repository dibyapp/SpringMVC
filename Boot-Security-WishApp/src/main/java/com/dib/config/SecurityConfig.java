package com.dib.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String USERS_BY_UNAME="SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?";
	private static final String ROLES_BY_UNAME="SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{	
		auth
		.jdbcAuthentication()
		.dataSource(ds)
		.usersByUsernameQuery(USERS_BY_UNAME)
		.authoritiesByUsernameQuery(ROLES_BY_UNAME);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		.authorizeRequests()
		.antMatchers("/home.htm")
		.access("permitAll")
		.antMatchers("/wish.htm")
		.access("hasAnyRole('ROLE_OWNER','ROLE_BOSS')")
		.and()
		.formLogin()
		.and()
		.rememberMe()
		.and()
		.logout()
		.logoutSuccessUrl("/home.htm")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access_failed.jsp");
		
	}

}
