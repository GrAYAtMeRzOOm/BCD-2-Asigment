/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gray.tutiontribe.security;

import com.gray.tutiontribe.entity.User;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grays
 */
@ApplicationScoped
public class SecurityAuthentication implements HttpAuthenticationMechanism {

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        System.out.println("---------------------Security Initailized---------------------------");
        User user = (User) request.getSession().getAttribute("domain-user");
        if (user != null) {
            SecuirityUserDetails userDetail = findByUserNameAndPassword(user);
            if (userDetail == null) {
                return httpMessageContext.responseUnauthorized();
            }
            return httpMessageContext.notifyContainerAboutLogin(
                    new SecurityPrincipal(userDetail),
                    new HashSet<>(userDetail.getRoles()));
        } else {
            return httpMessageContext.doNothing();
        }
    }

    private SecuirityUserDetails findByUserNameAndPassword(User u) {
        SecuirityUserDetails userDetail = new SecuirityUserDetails(u.getId(), u.getEmail(), u.getPassword());
        userDetail.addRole(u.getUserRole().getRoleName());
        return userDetail;
    }
}
