/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testservlet.user.dao.impl;

import com.mycompany.testservlet.user.dao.UserDAO;
import com.mycompany.testservlet.user.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Pócsi Kornél
 */
public class JdbcUserDAO implements UserDAO{

    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
    }
    
    public JdbcUserDAO(){
        
    }    
    
    @Override
    public List<User> getAllUsers() {        
        
            List<User> result = new ArrayList<>();
            String sql = "SELECT * FROM \"user\" ORDER BY id";
            Connection conn = null;
            
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            User item;
            while(rs.next()){
               item = new User(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("login"));
               result.add(item);
            }            
            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcUserDAO.class.getName()).log(Level.SEVERE, ex.getMessage());
        } finally {
            if (conn != null) {
                try {
                  conn.close();
                } catch (SQLException e) {}
            }
        }        
        
        return result;
    }

    @Override
    public User findUserByCredentials(String login, String password) {
      
        User result = null;
        
        
        return result;
    }
    
}
