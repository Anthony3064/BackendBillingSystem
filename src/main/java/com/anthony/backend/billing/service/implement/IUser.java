/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anthony.backend.billing.service.implement;

import com.anthony.backend.billing.entity.User;

/**
 *
 * @author anthony
 */
public interface IUser {

    public boolean save(User user);

    public User login(String userName, String password);

}
