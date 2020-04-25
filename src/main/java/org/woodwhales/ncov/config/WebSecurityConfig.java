package org.woodwhales.ncov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.woodwhales.ncov.security.MyUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserService myUserService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/index", "/about/**","/news/list", "/**").permitAll()
			.antMatchers("/admin/**").hasAnyRole("USER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/admin/login")
			.defaultSuccessUrl("/admin/index")
			.loginProcessingUrl("/login")
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/admin/login")
			.permitAll()
			.and()
			.headers()
			.frameOptions()
			.sameOrigin()
			.httpStrictTransportSecurity()
			.disable()
			.and()
			.csrf()
			.disable();
    }
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	     auth.userDetailsService(myUserService).passwordEncoder(passwordEncoder());
	 }

	@Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/admin/fonts/**",
				"/admin/css/**",
				"/admin/images/**",
				"/admin/js/**",
				"/admin/lib/**",
				"/webjars/**",
				"/css/**",
				"/**.png");
    }

}
