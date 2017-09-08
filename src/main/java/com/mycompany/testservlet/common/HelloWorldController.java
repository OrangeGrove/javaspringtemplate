/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testservlet.common;

import com.mycompany.testservlet.user.dao.UserDAO;
import com.mycompany.testservlet.user.model.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Pócsi Kornél
 */
public class HelloWorldController extends AbstractController{
    
    private ApplicationContext context;
    
    public HelloWorldController(){
        context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    }
    
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws java.lang.Exception
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception{
      
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        List<User> users = userDAO.getAllUsers();       
       
        ModelAndView model = new ModelAndView("/WEB-INF/jsp/index.jsp");
        model.addObject("msg", "user list");
        model.addObject("userList", users);

	return model;        
    }
    
}
