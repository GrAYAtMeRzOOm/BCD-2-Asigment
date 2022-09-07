/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Branch;
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
public class BranchManager implements BranchManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Override
    public Branch saveBranch(Branch branch) throws RuntimeException {
        if (branch != null) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.city=:city");
            query.setParameter("city", branch.getCity());
            if (query.getSingleResult() != null) {
                em.persist(branch);
            } else {
                throw new DataDuplicationException(branch.getCity() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("institute object is null");
        }
        return branch;
    }

    @Override
    public Branch getBranchByCity(String city) throws RuntimeException {
        if (!city.equals("")) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.city=:city");
            query.setParameter("city", city);
            Branch branch = (Branch) query.getSingleResult();
            return branch;
        } else {
            throw new DataNotFoundException("institute object is null");
        }
    }

    @Override
    public Branch getBranchById(long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.id=:id");
            query.setParameter("id", id);
            Branch branch = (Branch) query.getSingleResult();
            return branch;
        } else {
            throw new DataNotFoundException("institute object is null");
        }
    }

}
