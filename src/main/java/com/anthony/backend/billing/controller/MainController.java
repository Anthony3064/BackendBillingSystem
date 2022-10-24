/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.controller;

import com.anthony.backend.billing.security.service.MyUserDetailsService;
import com.anthony.backend.billing.security.util.JwtUtil;
import com.billing_system_model.exception.NotFoundException;
import com.billing_system_model.security.AuthenticationRequest;
import com.billing_system_model.security.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anthony
 */
@RestController
public class MainController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> generateJwt(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        if (userDetails == null) {
            throw new NotFoundException("Not found user details");
        }

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @GetMapping("/")
    public ResponseEntity<?> main() {
        return ResponseEntity.status(HttpStatus.OK).body("Server is running!!");
    }

}
