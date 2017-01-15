/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.executor;

import com.sample.dto.Users;
import com.sample.helper.RequestHelper;
import javax.ejb.Stateless;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.codec.digest.DigestUtils;

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

    @Override
    public Users createUser(RequestHelper requestHelper) {
        Users users = null;
        try {
            users = new Users();
            users.setFirstName(requestHelper.getUserHelper().getFirstName());
            users.setLastName(requestHelper.getUserHelper().getLastName());
            users.setEmail(requestHelper.getUserHelper().getEmail());
            users.setPassword(DigestUtils.md5Hex(requestHelper.getUserHelper().getPassword()));
            em.persist(users);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
}
