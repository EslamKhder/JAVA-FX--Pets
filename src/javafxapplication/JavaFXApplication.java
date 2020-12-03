package javafxapplication;

import controller.UserController;
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
        user.setUsername("ahmed");
        user.setPassword("12345");
        UserController uc = new UserController();
        System.out.println(uc.login(user));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Registers.fxml"));
        Scene scene = new Scene(root,600,500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}