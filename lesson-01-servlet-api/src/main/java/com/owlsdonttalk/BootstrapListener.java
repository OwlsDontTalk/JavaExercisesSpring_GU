package com.owlsdonttalk;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository userRepository = new UserRepository();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("userRepository", userRepository);

        userRepository.insert(new User("nickname1"));
        userRepository.insert(new User("nickname2"));
        userRepository.insert(new User("nickname3"));
        userRepository.insert(new User("nickname4"));
        userRepository.insert(new User("nickname5"));

    }
}
