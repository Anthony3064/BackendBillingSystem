/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthony.backend.billing.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author anthony
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "userName", nullable = false)
    private String userName = null;

    @Column(name = "password", nullable = false)
    private String password = null;

    @Column(name = "name", nullable = false)
    private String name = null;

    @Column(name = "email", nullable = false)
    private String email = null;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rol", nullable = false)
    private Detail rol = null;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", nullable = false)
    private Detail status = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Detail getRol() {
        return rol;
    }

    public void setRol(Detail rol) {
        this.rol = rol;
    }

    public Detail getStatus() {
        return status;
    }

    public void setStatus(Detail status) {
        this.status = status;
    }

}
