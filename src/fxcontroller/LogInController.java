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
public class LogInController implements Initializable {
    
    @FXML
    private ImageView loading;
    
    @FXML
    private AnchorPane login;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
    }
    
    @FXML
    void loginAction(ActionEvent event) {
        loading.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {
            System.out.println("oKKKKKKKKKKKKKKK");
        });
        pt.play();
    }
    
    @FXML
    void signUpPage(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        
        Parent root = FXMLLoader.load(getClass().getResource("/frontend/Registers.fxml"));
        Stage signup = new Stage();
        Scene scene = new Scene(root,600,650);
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
    }
}
