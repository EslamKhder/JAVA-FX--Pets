/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services_implementation;

import Services.UserService;
import dao.UserDao;
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
        return userDao.register(use);
    }

    
}
