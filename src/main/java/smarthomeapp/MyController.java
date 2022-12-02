package smarthomeapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@FxmlView("main-stage.fxml")
public class MyController{

    @FXML
    private Pane licht;

    @FXML
    private Button check;



    @FXML
    void changeColor(ActionEvent event) {
        licht.setStyle("-fx-background-color: blue");
    }

    @FXML
    void changeColorlicht(ActionEvent event) {
        if (API.AnAus.equals("an")){
            licht.setStyle("-fx-background-color: yellow");
            System.out.println(API.statuslicht);
        }

    }

}
