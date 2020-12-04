/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import controller.UserController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.User;

/**
 *
 * @author MBR
 */
public class SignupController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private TextField username;

    @FXML
    private AnchorPane signup;

    @FXML
    private ImageView loading;
    
    @FXML
    private Label invalid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
    }

    @FXML
    void logInPage(ActionEvent event) throws IOException {
        signup.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Login.fxml"));
        Stage login = new Stage();
        Scene scene = new Scene(root, 600, 500);
        login.setScene(scene);
        login.setResizable(false);
        login.show();
    }

    @FXML
    void signUp(ActionEvent event) {
        loading.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        User user = new User(username.getText(),password.getText(),phone.getText(),address.getText());
        UserController uc = new UserController();
        pt.setOnFinished(ev -> {
            if(uc.register(user) == 1){
                mainPage();
            } else {
                loading.setVisible(false);
                invalid.setText("username aleardy exist !");
                PauseTransition pt1 = new PauseTransition();
                pt1.setDuration(Duration.seconds(3));
                pt1.setOnFinished(e -> {
                    invalid.setText("");
                });   
                pt1.play();
            }
        });
        pt.play();
    }
    public void mainPage() {
        signup.getScene().getWindow().hide();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/frontend/Main.fxml"));
            Stage mainPage = new Stage();
            Scene scene = new Scene(root, 600, 650);
            mainPage.setScene(scene);
            mainPage.setResizable(false);
            mainPage.show();
        } catch (IOException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
