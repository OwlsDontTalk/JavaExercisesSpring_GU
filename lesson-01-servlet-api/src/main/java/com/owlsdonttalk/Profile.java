package com.owlsdonttalk;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/profile/*")
public class Profile extends HttpServlet{
    private ServletConfig config;
    private  UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.userRepository = (UserRepository) config.getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if(id==null)
        {
            resp.getWriter().println("<table>");
            for (User u:  userRepository.findAll()) {
                resp.getWriter().println("<tr> <td> User " + u.getId() + "</td><td>" + u.getUsername() + "</td></tr>");
            }
            resp.getWriter().println("</table>");
        }

        if(id!=null){
            resp.getWriter().println("User " + id + " : " + (userRepository.findById(Long.parseLong(id)).getUsername()));
        }
    }
}


