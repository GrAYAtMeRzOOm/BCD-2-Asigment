/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package com.gray.tutiontribe.information;

import com.gray.tutiontribe.entity.Branch;
import com.gray.tutiontribe.entity.User;
import com.gray.tutiontribe.entity.UserRole;
import com.gray.tutiontribe.exception.AuthenticationException;
import com.gray.tutiontribe.exception.DataDuplicationException;
import com.gray.tutiontribe.exception.DataNotFoundException;
import com.gray.tutiontribe.interceptor.WelcomeEmailInterceptor;
import java.util.ArrayList;
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
public class UserManager implements UserManagerRemote {

    @PersistenceContext(unitName = "TutionTribe-presitance-unit")
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Interceptors({WelcomeEmailInterceptor.class})
    @Override
    public User saveUser(User user, UserRole role, Branch branch) {
        if (user != null) {
            user.setUserRole(role);
            user.setBranch(branch);
            Query query = em.createQuery("SELECT u FROM User u WHERE u.name=:name OR u.contact=:contact");
            query.setParameter("name", user.getName()).setParameter("contact", user.getContact());
            if (query.getResultList().size() < 1) {
                em.persist(user);
            } else {
                throw new DataDuplicationException(user.getName() + " Already exit in Database");
            }
        } else {
            throw new DataNotFoundException("institute object is null");
        }
        return user;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public User getUserById(User u, long id) throws RuntimeException {
        if (id > 0) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.id=:id");
            query.setParameter("id", id);
            User user = (User) query.getSingleResult();
            return user;
        } else {
            throw new DataNotFoundException("cannot find data with id " + id);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public User getUserByContact(User u, String contact) {

        if (!contact.equals("")) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.contact =:contact");
            query.setParameter("contact", contact);
            User user = (User) query.getSingleResult();
            return user;
        } else {
            throw new DataNotFoundException("cannot find data with contact " + contact);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<User> getAllUsers(User u) throws RuntimeException {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        return em.createQuery(query).getResultList();

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public User userLogin(String email, String password) throws RuntimeException {
        if (!email.equals("") || !password.equals("")) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:pw");
            query.setParameter("email", email).setParameter("pw", password);
            User user = (User) query.getSingleResult();
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return user;
                } else {
                    throw new AuthenticationException("User email or password is Incorrect");
                }
            } else {
                throw new AuthenticationException("Cannot find User");
            }
        } else {
            throw new DataNotFoundException("institute object is null");
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public List<User> getAllUsersByRole(String role) throws RuntimeException {
        if (!role.equals("")) {
            Query query = em.createQuery("SELECT u FROM User u WHERE u.userRole.roleName =:role");
            query.setParameter("role", role);
            List<User> users = new ArrayList<>();
            for (Object object : query.getResultList()) {
                users.add((User) object);
            }
            return users;
        } else {
            throw new DataNotFoundException("cannot find data with contact " + role);
        }
    }

}
