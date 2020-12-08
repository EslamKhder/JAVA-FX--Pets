/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import controller.UserController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.User;

/**
 *
 * @author MBR
 */
public class ForgotPassword implements Initializable {

    @FXML
    private AnchorPane getPassword;

    @FXML
    private PasswordField lastDigts;

    @FXML
    private PasswordField firstDigts;

    @FXML
    private CheckBox last;

    @FXML
    private CheckBox first;

    @FXML
    private Label result;

    @FXML
    private PasswordField newpassword;

    @FXML
    private TextField username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        first.setSelected(true);
        last.setDisable(true);
        last.setDisable(true);
        lastDigts.setDisable(true);
        newpassword.setVisible(false);
    }

    @FXML
    void done(ActionEvent event) {
        UserController us = new UserController();
        User user;
        if (!first.isSelected() && !last.isSelected()) { // !false  !false
            result.setText("you must chech one only");
            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(2));
            pt.setOnFinished(ev -> {
                result.setText("");
            });
            pt.play();
            return;
        }
        if (first.isSelected()) {
            user = new User(username.getText(), firstDigts.getText());
            if (us.getUserByFirstDigts(user) == 1) {
                newpassword.setVisible(true);
                disabled();
            } else {
                invalidData();
            }
        } else {
            user = new User(username.getText(), lastDigts.getText());
            if (us.getUserByLastDigts(user) == 1) {
                newpassword.setVisible(true);
                disabled();
            } else {
                invalidData();
            }
        }
    }

    @FXML
    void firstDigts(ActionEvent event) {
        if (first.isSelected()) {
            last.setDisable(true);
            lastDigts.setDisable(true);
        } else {
            last.setDisable(false);
            lastDigts.setDisable(false);
        }
    }

    @FXML
    void lastDigits(ActionEvent event) {
        if (last.isSelected()) {
            first.setDisable(true);
            firstDigts.setDisable(true);
        } else {
            first.setDisable(false);
            firstDigts.setDisable(false);
        }
    }

    public void disabled() {
        first.setDisable(true);
        last.setDisable(true);
        last.setDisable(true);
        lastDigts.setDisable(true);
        username.setDisable(true);
        firstDigts.setDisable(true);
    }

    public void invalidData() {
        result.setText("Invalid Data");
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(ev -> {
            result.setText("");
        });
        pt.play();
    }
}
