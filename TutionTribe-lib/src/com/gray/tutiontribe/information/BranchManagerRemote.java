/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Branch;
import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface BranchManagerRemote {

    Branch saveBranch(Branch branch) throws RuntimeException;

    Branch getBranchByCity(String city) throws RuntimeException;

    Branch getBranchById(long id) throws RuntimeException;
    
}
