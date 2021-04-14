/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.UserLoginDTO;
import com.mii.server.dtos.UserSessionDTO;
import com.mii.server.entities.MyUserDetails;
import com.mii.server.entities.User;
import com.mii.server.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UnsupportedOperationException(" Username Not Found ");
        } else {
            MyUserDetails myUserDetails = new MyUserDetails(user);
            return myUserDetails;
        }
    }
    
    public UserSessionDTO login(UserLoginDTO userLoginDTO) throws Exception {
        UserDetails user = this.loadUserByUsername(userLoginDTO.getUsername());

        BCryptPasswordEncoder b = new BCryptPasswordEncoder(10);
        if (!(b.matches(userLoginDTO.getPassword(), user.getPassword()))) {
            throw new Exception(" Password Incorrect ");
        } else {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
            List<String> authorities = new ArrayList<>();
            for (GrantedAuthority auth : user.getAuthorities()) {
                authorities.add(auth.getAuthority());
            }
            return new UserSessionDTO(user.getUsername(), authorities);
        }
    }

}
