/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.gray.tutiontribe.attendance;

import com.gray.tutiontribe.entity.Attendance;
import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserAttendance;
import com.gray.tutiontribe.entity.UserRole;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import com.gray.tutiontribe.interceptor.LogInterceptor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author grays
 */
@Stateless
public class UserAttendanceManager implements UserAttendanceManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Override
    public UserAttendance saveUserAttendance(UserAttendance userAttendance) throws RuntimeErrorException {
        if (userAttendance != null) {
            Query query = em.createQuery("SELECT u FROM UserAttendance u WHERE u.user.id=:uId AND u.attendance.id=:aId");
            query.setParameter("uId", userAttendance.getUser().getId()).setParameter("aId", userAttendance.getAttendance().getId());
            if (query.getResultList().size() < 1) {
                em.persist(userAttendance);
            } else {
                throw new DataDuplicationException(userAttendance.getStatus() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("Cannot Find userAttendance object is null");
        }
        return userAttendance;
    }

    @Override
    public void setUserToLecture(User user, Lecture lecture) throws RuntimeException {
        if (user != null && lecture != null) {
            Query query = em.createQuery("SELECT a FROM Attendance a WHERE a.lecture.id=:lId").setParameter("lId", lecture.getId());
            if (!query.getResultList().isEmpty()) {
                Attendance a = (Attendance) query.getSingleResult();
                UserAttendance userAttendance = new UserAttendance();
                userAttendance.setAttendance(a);
                userAttendance.setUser(user);
                em.persist(userAttendance);
            } else {
                throw new DataNotFoundException("Cannot Find userAttendance object is null");
            }
        } else {
            throw new DataNotFoundException("Cannot Find userAttendance object is null");
        }
    }

    @Override
    public Boolean markUserAttendance(User student, Lecture lecture, String status) throws RuntimeException {
        if (student != null && lecture != null) {
            Query query = em.createQuery("SELECT u FROM UserAttendance u WHERE u.user.id=:uId AND u.attendance.lecture.id=:lId");
            query.setParameter("uId", student.getId()).setParameter("lId", lecture.getId());
            List resultList = query.getResultList();
            if (!resultList.isEmpty()) {
                UserAttendance userAttendance = (UserAttendance) resultList.get(0);
                userAttendance.setUser(student);
                userAttendance.setStatus(status);
                em.merge(userAttendance);
                return true;
            } else {
                return false;
            }
        } else {
            throw new DataNotFoundException("Cannot Find userAttendance object is null");
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Interceptors({LogInterceptor.class})
    @Override
    public List<UserAttendance> getAllUserAttendance(User user) throws RuntimeException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAttendance> query = builder.createQuery(UserAttendance.class);
        Root<UserAttendance> root = query.from(UserAttendance.class);
        query.select(root);
        List<UserAttendance> resultList = em.createQuery(query).getResultList();
        return resultList;
    }

    @Override
    public List<UserAttendance> getuserAttendancebyLectureId(long lid) throws RuntimeErrorException {
        if (lid > 0) {
            Query query = em.createQuery("SELECT u FROM UserAttendance u WHERE u.attendance.lecture.id=:id");
            query.setParameter("id", lid);
            List resultList = query.getResultList();
            List<UserAttendance> attendances = new ArrayList<>();
            for (Object object : resultList) {
                attendances.add((UserAttendance) object);
            }
            return attendances;
        } else {
            throw new DataNotFoundException("lecture id is null");
        }
    }

}
