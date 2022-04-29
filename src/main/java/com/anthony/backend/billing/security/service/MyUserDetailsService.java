/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.security.service;

import com.anthony.backend.billing.service.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author anthony
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.anthony.backend.billing.entity.User myUser = this.service.findByUserName(username);

        if (myUser != null) {
            return new User(myUser.getUserName(), myUser.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("No found user by username");
        }

    }

}
