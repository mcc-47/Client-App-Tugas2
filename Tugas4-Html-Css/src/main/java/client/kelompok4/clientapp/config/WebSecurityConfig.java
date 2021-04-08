/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.kelompok4.clientapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author LENOVO-KL
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/dashboard").authenticated()
//                .antMatchers("/province").hasAuthority("trainer")
//                .antMatchers("/district").hasAuthority("admin")
                .and()
                .formLogin()
                    .loginPage("/login").loginProcessingUrl("/login")
                    .failureForwardUrl("/login?error")
                    .successForwardUrl("/dashboard")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login");
    }
}
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/province").hasAuthority("TRAINER")
//                .antMatchers("/**","logout").authenticated()
//                .antMatchers("login").denyAll()
//                .and()
//                .formLogin()
//                .loginPage("/login").loginProcessingUrl("/login")
//                .failureForwardUrl("/login?error")
//                .successForwardUrl("/dashboard")
//                .permitAll();
    
