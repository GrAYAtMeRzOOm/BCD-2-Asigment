/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.attendance;

import com.gray.tutiontribe.entity.Attendance;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author grays
 */
@Remote
public interface AttendanceManagerRemote {

    Attendance saveAttendance(Attendance attendance) throws RuntimeException;

    
    
}
