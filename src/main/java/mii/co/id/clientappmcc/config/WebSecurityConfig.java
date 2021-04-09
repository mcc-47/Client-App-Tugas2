/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                .antMatchers("/employee/new").hasAnyRole("ADMIN","TRAINEE")
                .antMatchers("/employee/{id}").hasAnyRole("ADMIN","TRAINEE")
                .antMatchers("/employee/update/{id}").hasAnyRole("ADMIN","TRAINEE")
                .antMatchers("/employee/delete/{id}").hasAnyRole("ADMIN")
                .antMatchers("/employee/create").hasAnyRole("ADMIN","TRAINER","TRAINEE")
                .antMatchers("/css/**","/js/**").permitAll()
                .antMatchers("/dashboard","/employee/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .successForwardUrl("/dashboard")
                .permitAll();
//                .and()
//                .logout().disable()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");
    }
}
