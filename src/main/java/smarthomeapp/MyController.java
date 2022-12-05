package smarthomeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import smarthomeapp.Vaadinpackage.API;

@Component
@FxmlView("main-stage.fxml")
public class MyController{

    @FXML
    private Pane licht1;

    @FXML
    private Pane licht2;

    @FXML
    private Button check;



    @FXML
    void changeColor(ActionEvent event) {
        licht1.setStyle("-fx-background-color: blue");
        licht2.setStyle("-fx-background-color: blue");
    }

    @FXML
    void changeColorlicht(ActionEvent event) {
        System.out.println(API.lightvalue1);
        if (API.lightvalue1){
            licht1.setStyle("-fx-background-color: yellow");

        } else {
            licht1.setStyle("-fx-background-color: black");
        } if (API.lightvalue2){
            licht2.setStyle("-fx-background-color: yellow");
        }else {
            licht2.setStyle("-fx-background-color: black");
        }

    }

}
