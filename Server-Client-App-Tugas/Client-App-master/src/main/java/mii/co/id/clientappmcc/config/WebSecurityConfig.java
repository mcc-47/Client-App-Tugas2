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
 * @author William Yangjaya
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/dashboard","/contacts").authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").loginProcessingUrl("/login")
                    .failureForwardUrl("/login?error")
                    .successForwardUrl("/dashboard")
                    .permitAll();
        
        //        http
        //                .csrf().disable()
        //                .authorizeRequests()
        //                .and()
        //                .formLogin()
        //                .loginPage("/login").loginProcessingUrl("/login")
        //                .failureForwardUrl("/login?error")
        //                .successForwardUrl("/dashboard")
        //                .permitAll();
    }
}
