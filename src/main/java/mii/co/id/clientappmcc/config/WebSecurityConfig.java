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
 * @author User
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/dashboard","/district","/province").authenticated()//izinkan path ini setelah login sukses kepada siapapun
//                .antMatchers("/login").not().authenticated()
//                .antMatchers("/province").hasAnyAuthority("TRAINER")//izinkan path ini province hanya bisa diakses oleh ADMIN dan udah terauthenticated
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")//login page ke /login, post ke /login
                .failureForwardUrl("/login?error")//kalau eror redirect ke /login eror
                .successForwardUrl("/dashboard")// kalau berhasil redirect ke dashba
                .permitAll()
                
            
               
                ;
                
                
    }
    
}
