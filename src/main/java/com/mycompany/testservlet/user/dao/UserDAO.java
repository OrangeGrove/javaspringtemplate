/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testservlet.user.dao;

import com.mycompany.testservlet.user.model.User;
import java.util.List;

/**
 *
 * @author Pócsi Kornél
 */
public interface UserDAO { 
    
    public List<User> getAllUsers();
    
    public User findUserByCredentials(String login, String password);
    
}
