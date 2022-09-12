/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.security;

import java.security.Principal;

/**
 *
 * @author grays
 */
public class SecurityPrincipal implements Principal {

    private SecuirityUserDetails userDetail;

    public SecurityPrincipal(SecuirityUserDetails userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String getName() {
        return userDetail.getLogin();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + getName();
    }
}
