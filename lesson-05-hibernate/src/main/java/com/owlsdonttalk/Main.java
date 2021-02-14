package com.owlsdonttalk;

import com.owlsdonttalk.persist.User;
import com.owlsdonttalk.persist.UserRepository;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManagerFactory;
import java.util.List;


//TODO hibernate userRepository
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        final UserRepository userRepository = new UserRepository(emFactory);

        User u0 = new User("name4");
        userRepository.insert(u0);
        u0.setUsername("name5");
        userRepository.update(u0);
        userRepository.delete((long)1);
        List<User> list = userRepository.findAll();


        for (User u:list) {
            System.out.println(u.getUsername());
            System.out.println(u.getId());
        }



    }
}
