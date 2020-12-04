package javafxapplication;

import controller.UserController;
import dao.UserDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

/**
 *
 * @author MBR
 */
public class JavaFXApplication extends Application{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        User user = new User();
        user.setUsername("eslam");
        user.setPassword("12345");
        user.setPhone("01113903660");
        user.setAddress("shibeen");
        //UserController uc = new UserController();
        UserDao dao = new UserDao();
        System.out.println(dao.register(user));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Login.fxml"));
        Scene scene = new Scene(root,600,530);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}