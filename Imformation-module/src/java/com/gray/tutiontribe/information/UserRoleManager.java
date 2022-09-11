/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserRole;
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

@Stateless
public class UserRoleManager implements UserRoleManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    /**
     *
     * @param u
     * @return @throws RuntimeException
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<UserRole> getAllUserRoles(User u) throws RuntimeException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
        Root<UserRole> root = query.from(UserRole.class);
        query.select(root);
        List<UserRole> resultList = em.createQuery(query).getResultList();
        UserRole ownerRole = null;
        for (UserRole userRole : resultList) {
            if (userRole.getRoleName().equals("Owner")) {
                ownerRole = userRole;
            }
        }
        if (ownerRole != null) {
            resultList.remove(ownerRole);
        }
        return resultList;
    }
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Interceptors({LogInterceptor.class})
    @Override
    public UserRole getRoleByName(User u,String name) throws RuntimeException {
        
        if (!name.equals("")) {
            Query query = em.createQuery("SELECT u FROM UserRole u WHERE u.roleName =:name");
            query.setParameter("name", name);
            UserRole nameRole = (UserRole) query.getSingleResult();
            return nameRole;
        } else {
            throw new DataNotFoundException("cannot find data with contact " + name);
        }
    }
    
    
    
}
