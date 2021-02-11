package com.owlsdonttalk.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class UserRepository {

    private final EntityManagerFactory emFactory;
    private EntityManager em;

    public UserRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
        this.em = emFactory.createEntityManager();
        em.getTransaction().begin();
        init();
    }

    private void init(){
        User u1 = new User("name1");
        User u2 = new User("name2");
        User u3 = new User("name3");

        em.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);
        em.getTransaction().commit();

    }

    public List<User> findAll() {
        List<User> userList = em.createQuery("from User", User.class)
                .getResultList();

        return userList;
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void insert(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }
}
