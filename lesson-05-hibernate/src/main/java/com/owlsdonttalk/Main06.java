package com.owlsdonttalk;

import com.owlsdonttalk.persist.Product;
import org.hibernate.cfg.Configuration;
import com.owlsdonttalk.persist.Contact;
import com.owlsdonttalk.persist.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class Main06 {
    private List<User> users;

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        User user = new User("user1", "password1", "user1@mail.com");
        User user2 = new User("user2", "password2", "user2@mail.com");
        em.persist(user);
        em.persist(user2);
        em.getTransaction().commit();
        em.close();

        EntityManager em0 = emFactory.createEntityManager();
        em0.getTransaction().begin();
        List<Contact> contacts = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        //contacts.add(new Contact("home phone", "(095)343-15-62", user));
        products.add(new Product("food", 10.2, user));
        products.add(new Product("phone", 1000.0, user));
        products.add(new Product("phone", 1000.0, user2));
        //contacts.forEach(em::persist);
        products.forEach(em0::persist);
        em0.getTransaction().commit();
        em0.close();



//        // SELECT for one to many
//        User user0 = em.find(User.class, 1L);
//        user0.getContacts().forEach(System.out::println);
//
//        List<Contact> contacts0 = em.createQuery(
//                "select c from User u " +
//                        "inner join Contact c on u.id = c.user.id " +
//                        "where c.type = 'mobile phone'", Contact.class)
//                .getResultList();
//
//        contacts.forEach(System.out::println);
//
//        List<String> usernames = em.createQuery(
//                "select new java.lang.String(u.username) from User u " +
//                        "inner join Contact c on u.id = c.user.id " +
//                        "where c.type = 'mobile phone'", String.class)
//                .getResultList();
//
//        System.out.println(usernames);
    }

}
