package com.owlsdonttalk.persist;

import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private Map<Long, User> userMap = new ConcurrentHashMap<>();

    private AtomicLong identity = new AtomicLong(0);

    @PersistenceContext
    private EntityManager em;

    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void insert(User user) {
        em.persist(user);
    }

    @Transactional
    public void update(User user) {
        em.merge(user);
    }

    @Transactional
    public void delete(long id) {
       em.createQuery("delete from User where id = :id")
               .setParameter("id", id)
               .executeUpdate();
    }

}
