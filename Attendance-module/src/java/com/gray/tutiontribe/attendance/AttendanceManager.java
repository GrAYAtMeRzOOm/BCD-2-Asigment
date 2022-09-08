/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.attendance;

import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author grays
 */
@Stateful
public class AttendanceManager implements AttendanceManagerRemote {
    
//    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
//    private EntityManager em;

    @Override
    public void setAttendanceToStudent(Lecture lecture, User student) {
//        System.out.println("em"+em);
    }

    
}
