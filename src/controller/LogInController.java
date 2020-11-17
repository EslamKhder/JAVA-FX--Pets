package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author MBR
 */
public class LogInController implements Initializable {

    
    @FXML
    private ImageView loading;
    
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
    
    
}
