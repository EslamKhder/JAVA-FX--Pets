/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Services_implementation.UserServiceImpl;
import model.User;

/**
 *
 * @author MBR
 */
public class UserController {
    private UserServiceImpl userServiceImpl;

    public UserController() {
        
        userServiceImpl = new UserServiceImpl();
    }
    
    
    public int login(User user){
        return userServiceImpl.login(user);
    }
}
