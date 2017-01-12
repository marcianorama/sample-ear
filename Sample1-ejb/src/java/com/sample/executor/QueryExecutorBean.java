/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.executor;

import com.sample.dto.Users;
import javax.ejb.Stateless;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MATET
 */
@Stateless
public class QueryExecutorBean implements QueryExecutorLocal {

    @PersistenceContext(unitName = "sample")
    private EntityManager em;

    private Session getSession() {
        return (Session) em.getDelegate();
    }

    public Users getUsersExist(String email) {
        Users users = null;
        try {
            users = (Users) em.createQuery("select from Users u where u.email=:email").setParameter("email", email).getSingleResult();
        } catch (Exception e) {
        }
        return users;
    }
}
