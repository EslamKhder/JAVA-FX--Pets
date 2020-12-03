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
}
