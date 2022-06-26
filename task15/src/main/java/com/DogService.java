package com;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("dogService")
@RequiredArgsConstructor
public class DogService {
    private final SessionFactory sessionFactory;
    private Session session;

    public User getUserByDog(long dogId) {
        session = sessionFactory.openSession();
        Dog dog = session.createQuery("select d from Dog d join fetch  d.user where d.id = :id", Dog.class)
                .setParameter("id", dogId).getSingleResult();
        User us = dog.getUser();
        Hibernate.initialize(us.getDogs());
        session.close();
        return us;
    }

    public Dog read(long id) {
        session = sessionFactory.openSession();
        Dog dog = session.createQuery("select d from Dog d where d.id = :id", Dog.class).
                setParameter("id", id).getSingleResult();
        session.close();
        return dog;
    }

    public List<Dog> getDogs() {
        session = sessionFactory.openSession();
        List<Dog> dgs = session.createQuery("select d from Dog d", Dog.class).getResultList();
        session.close();
        return dgs;
    }

    public void saveDog(Dog dog) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(dog);
        transaction.commit();
        session.close();
    }

    public void deleteDog(Dog dog) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(dog);
        transaction.commit();
        session.close();
    }

    public List<Dog> dogFilter(String field, String value) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<Dog> userCriteriaQuery = criteria.createQuery(Dog.class);
        Root<Dog> dogRoot = userCriteriaQuery.from(Dog.class);
        userCriteriaQuery.select(dogRoot).where(criteria.like(dogRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        List<Dog> dogs = query.getResultList();
        transaction.commit();
        session.close();
        return dogs;
    }
}

