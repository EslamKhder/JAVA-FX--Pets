/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services_implementation;

import Services.UserService;
import dao.UserDao;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author MBR
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDao();
    }
    
    @Override
    public int login(User use) {
        if(use.getUsername().trim().isEmpty() || use.getPassword().trim().isEmpty()){
            return 0;
        }
        return userDao.signup(use);
    }

    @Override
    public int signUp(User user) {
        if(user.getUsername().trim().isEmpty() || user.getPassword().trim().isEmpty() ||
          user.getPhone().trim().isEmpty() || user.getAddress().trim().isEmpty()){
            return 2;
        }
        if(user.getUsername().length() < 5){
            return 3;
        }
        if(user.getPassword().length() < 7){
            return 4;
        }
        if(user.getPhone().length() < 11 || user.getPhone().length() > 11){
            return 5;
        }
        try {
            Integer.parseInt(user.getPhone());
        } catch (Exception e) {
            return 6;
        }
        
        return userDao.register(user);
    }
}
