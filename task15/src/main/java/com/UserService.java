package com;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("userService")
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public UserService(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    public User read(long id) {
        session = sessionFactory.openSession();
        User usr = session.createQuery("select u from User u where u.id = :id", User.class).
                setParameter("id", id).getSingleResult();
        Hibernate.initialize(usr.getDogs());
        session.close();
        return usr;
    }

    public List<User> getUsers() {
        session = sessionFactory.openSession();
        List<User> usrs = session.createQuery("select u from User u", User.class).getResultList();
        for (User usr : usrs) {
            Hibernate.initialize(usr.getDogs());
        }
        session.close();
        return usrs;
    }

    public void saveUser(User user) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public boolean deleteUser(User user) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Удаляем пользователя
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }

    public List<User> userFilter(String field, String value) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteria.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot).where(criteria.like(userRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        List<User> usrs = query.getResultList();
        for (User usr : usrs) {
            Hibernate.initialize(usr.getDogs());
        }
        transaction.commit();
        session.close();
        return usrs;
    }
}
