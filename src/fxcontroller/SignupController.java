/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author MBR
 */
public class SignupController implements Initializable{
    @FXML
    private AnchorPane signup;
    
    @FXML
    private ImageView loading;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
    }
    
    @FXML
    void logInPage(ActionEvent event) throws IOException {
        signup.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Registers.fxml"));
        Stage login = new Stage();
        Scene scene = new Scene(root,600,500);
        login.setScene(scene);
        login.setResizable(false);
        login.show();
    }
    @FXML
    void signUp(ActionEvent event) {
        loading.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {
            System.out.println("oKKKKKKKKKKKKKKK");
        });
        pt.play();
    }
    
}
