/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Institute;
import com.gray.tutiontribe.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface InstituteManagerRemote {

    Institute saveInstitute(User u,Institute institute) throws RuntimeException;

    Institute getInstituteById(User u,long id)throws RuntimeException;

    Institute getInstituteByName(User u,String name);
    
}
