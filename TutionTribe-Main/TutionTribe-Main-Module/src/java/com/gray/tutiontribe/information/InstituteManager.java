/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Institute;
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
public class InstituteManager implements InstituteManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Override
    public Institute saveInstitute(Institute institute) throws RuntimeException {
        if (institute != null) {
            Query query = em.createQuery("SELECT i FROM Institute i WHERE i.name=:name");
            query.setParameter("name", institute.getName());
            if (query.getSingleResult() != null) {
                em.persist(institute);
            } else {
                throw new DataDuplicationException(institute.getName() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("institute object is null");
        }
        return institute;
    }

    @Override
    public Institute getInstituteById(long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT i FROM Institute i WHERE i.id=:id");
            query.setParameter("id", id);
            Institute institute = (Institute) query.getSingleResult();
            return institute;
        } else {
            throw new DataNotFoundException("cannot find data with id " + id);
        }
    }

    @Override
    public Institute getInstituteByName(String name) {
        if (!name.equals("")) {
            Query query = em.createQuery("SELECT i FROM Institute i WHERE i.name:name");
            query.setParameter("name", name);
            Institute institute = (Institute) query.getSingleResult();
            return institute;
        } else {
            throw new DataNotFoundException("cannot find data with name " + name);
        }
    }
    
}
