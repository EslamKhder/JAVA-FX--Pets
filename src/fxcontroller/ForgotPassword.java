/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        first.setSelected(true);
        last.setDisable(true);
        last.setDisable(true);
        lastDigts.setDisable(true);
    }

    @FXML
    void done(ActionEvent event) {
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
            System.out.println(firstDigts.getText());
        } else {
            System.out.println(lastDigts.getText());
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
}
