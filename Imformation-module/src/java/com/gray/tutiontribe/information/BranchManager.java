/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import com.gray.tutiontribe.interceptor.LogInterceptor;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
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
public class BranchManager implements BranchManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Interceptors({LogInterceptor.class})
    @Override
    public Branch saveBranch(User u,Branch branch) throws RuntimeException {
        if (branch != null) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.city=:city");
            query.setParameter("city", branch.getCity());
            if (query.getResultList().size() < 1) {
                em.persist(branch);
            } else {
                throw new DataDuplicationException(branch.getCity() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("Cannot Find branch object is null");
        }
        return branch;
    }
    @Interceptors({LogInterceptor.class})
    @Override
    public Branch getBranchByCity(User u,String city) throws RuntimeException {
        if (!city.equals("")) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.city=:city");
            query.setParameter("city", city);
            Branch branch = (Branch) query.getSingleResult();
            return branch;
        } else {
            throw new DataNotFoundException("Cannot Find branch object is null");
        }
    }
    
    @Interceptors({LogInterceptor.class})
    @Override
    public Branch getBranchById(User u,long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.id=:id");
            query.setParameter("id", id);
            Branch branch = (Branch) query.getSingleResult();
            return branch;
        } else {
            throw new DataNotFoundException("Cannot Find branch object is null");
        }
    }
    
    @Interceptors({LogInterceptor.class})
    @Override
    public Branch getBranchByName(User u,String name) throws RuntimeException {
        if (!name.equals("")) {
            Query query = em.createQuery("SELECT b FROM Branch b WHERE b.name=:name");
            query.setParameter("name", name);
            Branch branch = (Branch) query.getSingleResult();
            return branch;
        } else {
            throw new DataNotFoundException("Cannot Find branch object is null");
        }
    }
    

    @Interceptors({LogInterceptor.class})
    @Override
    public List<Branch> getAllbranches(User u) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Branch> query = builder.createQuery(Branch.class);
        Root<Branch> root = query.from(Branch.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
    

}
