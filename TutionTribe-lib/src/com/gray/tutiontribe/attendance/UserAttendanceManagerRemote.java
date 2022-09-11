/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.gray.tutiontribe.attendance;

import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserAttendance;
import java.util.List;
import javax.ejb.Remote;
import javax.management.RuntimeErrorException;

/**
 *
 * @author grays
 */
@Remote
public interface UserAttendanceManagerRemote {

    UserAttendance saveUserAttendance(UserAttendance userAttendance) throws RuntimeErrorException;

    void setUserToLecture(User user, Lecture lecture) throws RuntimeException;

    Boolean markUserAttendance(User student, Lecture lecture, String status) throws RuntimeException;    

    List<UserAttendance> getAllUserAttendance(User user) throws RuntimeException;

    List<UserAttendance> getuserAttendancebyLectureId(long lid) throws RuntimeErrorException;

    List<UserAttendance> getuserAttendancebyLectureIdAndUserId(long lId, long uId) throws RuntimeException;

    List<UserAttendance> getuserAttendancebyUserId(long uid) throws RuntimeException;
}
