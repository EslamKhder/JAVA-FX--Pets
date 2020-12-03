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
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author MBR
 */
public class LogInController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private ImageView loading;

    @FXML
    private AnchorPane login;

    @FXML
    private Label validate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
    }

    @FXML
    void loginAction(ActionEvent event) {
        loading.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setOnFinished(ev -> {
            UserController uc = new UserController();
            int result = uc.login(new User(username.getText(), password.getText()));
            if (result == 1) {
                mainPage();
            } else {
                loading.setVisible(false);
                validate.setText("Invalid UserName and Password");
                PauseTransition pt1 = new PauseTransition();
                pt1.setDuration(Duration.seconds(3));
                pt1.setOnFinished(e -> {
                    validate.setText("");
                });
                pt1.play();
            }
        });
        pt.play();
    }

    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Registers.fxml"));
        Stage signup = new Stage();
        Scene scene = new Scene(root, 600, 650);
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
    }

    public void mainPage() {
        login.getScene().getWindow().hide();
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
