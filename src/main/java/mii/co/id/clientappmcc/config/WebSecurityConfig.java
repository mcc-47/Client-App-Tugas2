/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

/**
 *
 * @author ASUS
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/employee/{id}").hasAnyRole("ADMIN","TRAINEE")
                .antMatchers(HttpMethod.PUT,"/employee/{id}").hasAnyRole("ADMIN","TRAINEE")
                .antMatchers(HttpMethod.DELETE,"/employee/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/employee").hasAnyRole("ADMIN","TRAINER","TRAINEE")
                .antMatchers("/css/**","/js/**").permitAll()
                .antMatchers("/dashboard","/employee/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .successForwardUrl("/dashboard")
                .permitAll();
    }
    
    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }
}
