/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.attendance;

import com.gray.tutiontribe.entity.Attendance;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author grays
 */
@Stateful
public class AttendanceManager implements AttendanceManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;
    
    @Override
    public Attendance saveAttendance(Attendance attendance) throws RuntimeException {
       if (attendance != null) {
            Query query = em.createQuery("SELECT u FROM Attendance u WHERE u.lecture.id =:lecId AND u.lecturer.id=:uId");
            query.setParameter("lecId", attendance.getLecture().getId()).setParameter("uId",attendance.getLecturer().getId());
            if (query.getResultList().size() < 1) {
                em.persist(attendance);
            } else {
                throw new DataDuplicationException(attendance.getId() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("Cannot Find Attendance object is null");
        }
        return attendance;
    }
    
//    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
//    private EntityManager em;

    
}
