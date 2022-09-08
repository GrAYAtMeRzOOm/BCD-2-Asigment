/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface BranchManagerRemote {

    Branch saveBranch(User u,Branch branch) throws RuntimeException;

    Branch getBranchByCity(User u,String city) throws RuntimeException;

    Branch getBranchById(User u,long id) throws RuntimeException;
    
    Branch getBranchByName(User u,String name) throws RuntimeException;

    List<Branch> getAllbranches(User u);
    
}
