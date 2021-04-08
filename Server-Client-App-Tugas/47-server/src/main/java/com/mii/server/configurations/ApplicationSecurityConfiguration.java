/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.configurations;

import com.mii.server.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author William Yangjaya
 */
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

//    @Autowired
//    private UserDetailsService userDetailsService;

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.parentAuthenticationManager(authenticationManagerBean());
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // untuk role server
        http
                .csrf().disable()
                .authorizeRequests()
                // no auth ada ataupun tidak ada permit all berjalan
                
                // dengan basic auth
                .antMatchers("/api/admin").hasRole("ADMIN") // url ini cuma bisa diakses oleh role ADMIN, jika diakses oleh role lain maka status code 403 (forbidden), kalau akun usernya tidak ada maka status code 401 (unauthorized)
                .antMatchers("/api/user").hasAnyRole("USER","ADMIN") // url ini cuma bisa diakses oleh role USER atau ADMIN, jika diakses oleh role lain maka status code 403 (forbidden), kalau akun usernya tidak ada maka status code 401 (unauthorized)
                
//                .antMatchers(HttpMethod.POST,"/api/contacts","...").hasAnyAuthority("create_satu","create_dua") // harus lebih specific
                .antMatchers(HttpMethod.POST,"/api/contacts").hasAuthority("create") // hanya bisa dilakukan oleh admin
                
//                .antMatchers(HttpMethod.PUT,"/api/contacts/**").hasAnyRole("ADMIN","")
                .antMatchers(HttpMethod.PUT,"/api/contacts/**").hasRole("ADMIN")// user hanya memiliki akses read saja, cek akses read
                                                                         // sedangkan admin crud
                                                                         // sudah ditambahkan preauthorize admin pada method put
//                .antMatchers("/api/get").hasAuthority("READ")
//                .antMatchers("/api/getall").hasAuthority("READ")
                
//                .antMatchers("/api/admin").hasAuthority("CREATE") // lebih tinggi hierarki
//                .antMatchers("/api/admin","/api/contacts/**").hasRole("ADMIN")
//                .antMatchers("/api/user").hasRole("USER")
//                .antMatchers("/api/**").permitAll()
//                .anyRequest().permitAll()
                .and()
                .formLogin().disable()
                .logout().disable()
                .httpBasic();
    }
}

//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/","/registration").permitAll()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().invalidateHttpSession(true).clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout").permitAll()
//                .and()
//                .httpBasic();
//    }
