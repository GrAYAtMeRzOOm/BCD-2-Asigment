/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.controller;

import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface LectureUpdateRemote {

    void sendAllLecturetoUser() throws RuntimeException;
    
}
