/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Lecture;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class LectureManager implements LectureManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Override
    public Lecture saveLecture(User u,Lecture lecture) throws RuntimeException {
        if (lecture != null) {
            Query query = em.createQuery("SELECT l FROM Lecture l WHERE l.startedTime=:start AND l.endedTime= :end AND l.subject=:subject");
            query.setParameter("start", lecture.getStartedTime()).setParameter("end", lecture.getEndedTime()).setParameter("subject", lecture.getSubject());
            if (query.getResultList().size() < 1) {
                em.persist(lecture);
            } else {
                throw new DataDuplicationException(lecture.getSubject() + " Already exit in Database in same time");
            }
        } else {
            throw new DataNotFoundException("lecture object is null");
        }
        return lecture;
    }

    @Override
    public Lecture getLectureById(User u,long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT l FROM Lecture l WHERE l.id=:id");
            query.setParameter("id", id);
            Lecture lecture = (Lecture) query.getSingleResult();
            return lecture;
        } else {
            throw new DataNotFoundException("lecture object is null");
        }
    }

    @Override
    public List<Lecture> getAllLecture(User u) throws RuntimeException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Lecture> query = builder.createQuery(Lecture.class);
        Root<Lecture> variableRoot = query.from(Lecture.class);
        query.select(variableRoot);
        return em.createQuery(query).getResultList();
    }

}
