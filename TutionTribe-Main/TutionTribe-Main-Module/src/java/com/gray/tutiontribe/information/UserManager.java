/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import java.util.List;
import javax.ejb.Stateful;
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
@Stateful
public class UserManager implements UserManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @Override
    public User saveUser(User user) {
        if (user != null) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.name=:name OR u.contact=:contact");
            query.setParameter("name", user.getName());
            if (query.getSingleResult() != null) {
                em.persist(user);
            } else {
                throw new DataDuplicationException(user.getName() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("institute object is null");
        }
        return user;
    }

    @Override
    public User getUserById(long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            User user = (User) query.getSingleResult();
            return user;
        } else {
            throw new DataNotFoundException("cannot find data with id " + id);
        }
    }

    @Override
    public User getUserByContact(String contact) {
        if (!contact.equals("")) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.contact =:contact");
            query.setParameter("contact", contact);
            User user = (User) query.getSingleResult();
            return user;
        } else {
            throw new DataNotFoundException("cannot find data with contact " + contact);
        }
    }

    
    
    @Override
    public List<User> getAllUsers() throws RuntimeException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return em.createQuery(query).getResultList();

    }

}
