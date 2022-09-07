/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.UserRole;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface UserRoleManagerRemote {

    List<UserRole> getAllUserRoles() throws RuntimeException;
    
}
