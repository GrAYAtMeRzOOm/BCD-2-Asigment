/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.UserRole;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author grays
 */
@Stateless
public class UserRoleManager implements UserRoleManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;
    /**
     *
     * @return
     * @throws RuntimeException
     */
    @Override
    public List<UserRole> getAllUserRoles() throws RuntimeException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
        Root<UserRole> root = query.from(UserRole.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
