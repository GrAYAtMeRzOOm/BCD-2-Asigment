/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.security;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grays
 */
public class SecuirityUserDetails {

    private Long uid;
    private String login;
    private String password;
    private List<String> roles = new ArrayList<>();

    public SecuirityUserDetails(Long uid, String login, String password) {
        this.uid = uid;
        this.login = login;
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void addRole(String role) {
        roles.add(role);
    }
    
    
}
