/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.service;

import com.anthony.backend.billing.entity.User;
import com.anthony.backend.billing.exception.BadRequestException;
import com.anthony.backend.billing.exception.NotFoundException;
import com.anthony.backend.billing.repository.UserRepository;
import com.anthony.backend.billing.service.implement.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author anthony
 */
@Service("userService")
public class UserService implements IUser {

    @Autowired
    private UserRepository repository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean save(User user) {

        boolean saved = false;

        if (user != null) {

            String passwordEncode = this.passwordEncoder.encode(user.getPassword());

            user.setPassword(passwordEncode);

            User userInserted = repository.save(user);
            if (userInserted != null) {
                saved = true;
            } else {
                throw new BadRequestException("Error saving user");
            }

        } else {
            throw new BadRequestException("User is required");
        }
        return saved;
    }

    @Override
    public User login(String userName, String password) {

        if (userName != null && !userName.isEmpty()) {

            User userFound = this.repository.findByUserName(userName);

            if (userFound != null) {

                boolean userValid = this.passwordEncoder.matches(password, userFound.getPassword());

                if (userValid) {
                    return userFound;
                } else {
                    throw new NotFoundException("Username or password is incorrect");
                }

            } else {
                throw new NotFoundException("No found user");
            }

        } else {
            throw new BadRequestException("Username is required");
        }

    }

    @Override
    public User findByUserName(String userName) {

        if (userName != null && !userName.isEmpty()) {

            User userFound = repository.findByUserName(userName);

            if (userFound != null) {
                return userFound;
            } else {
                throw new NotFoundException("No found data");
            }

        } else {
            throw new BadRequestException("Username is required");
        }

    }

}
