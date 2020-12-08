package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author MBR
 */
/* */
public class UserDao {
    
    private Connection connection = null;
    private String sql = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private int result = 0;
    public UserDao() {
    }
    
    public int signup(User user){
        connection = DatabaseConnection.connect();
        sql = "SELECT username,password FROM USER WHERE username = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int register(User user){
        connection = DatabaseConnection.connect();
        sql= "INSERT INTO USER (username, password, phone, address) values (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, user.getUsername());
           preparedStatement.setString(2, user.getPassword());
           preparedStatement.setString(3, user.getPhone());
           preparedStatement.setString(4, user.getAddress());
           result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
     public int getUserByFirstDigts(User user){
        connection = DatabaseConnection.connect();
        sql= "SELECT password FROM USER WHERE username = ? and password LIKE ?";
        try {
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, user.getUsername());
           preparedStatement.setString(2, user.getPassword() + "%");
           resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public int getUserByLastDigts(User user){
        connection = DatabaseConnection.connect();
        sql= "SELECT password FROM USER WHERE username = ? and password like ?";
        try {
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, user.getUsername());
           preparedStatement.setString(2, "%" + user.getPassword());
           resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int editUserPassword(User user){
        connection = DatabaseConnection.connect();
        sql= "UPDATE USER SET password = ? WHERE username = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
           preparedStatement.setString(2, user.getUsername());
           
           result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
