package smarthomeapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import smarthomeapp.Vaadinpackage.API;

@Component
@FxmlView("VirtualHome.fxml")
public class FXController {

    @FXML
    private Pane lampeFuss;

    @FXML
    private Pane lampeLicht;

    @FXML
    private Pane verdunkelung;



    @FXML
    void switchToElevator(ActionEvent event) {

    }


    @FXML //Event für Button - Aktualisierung
    void changeColorlicht(ActionEvent event) {

        if (API.lightvalue1){
            //licht1.setStyle("-fx-background-color: yellow");
            verdunkelung.setStyle("-fx-opacity: 0.0");
            verdunkelung.setStyle("-fx-background-color:null");
            lampeLicht.setStyle("-fx-background-color:#ffff66");
            lampeFuss.setStyle("-fx-background-color: linear-gradient(to bottom, #ffff66,#334152);");

            System.out.println("Licht 1 Button pressed: Value=" + API.lightvalue1);

        } else {
//            licht1.setStyle("-fx-background-color: black");
            verdunkelung.setStyle("-fx-opacity: 0.6");
            verdunkelung.setStyle("-fx-background-color:#334152");
            lampeLicht.setStyle(null);
            lampeFuss.setStyle(null);
            System.out.println("Licht 1 Button pressed: Value=" + API.lightvalue1);

        } if (API.lightvalue2){
//            licht2.setStyle("-fx-background-color: yellow");
            System.out.println("Licht 2 Button pressed: Value=" + API.lightvalue2);
        }else {
//            licht2.setStyle("-fx-background-color: black");
            System.out.println("Licht 2 Button pressed: Value=" + API.lightvalue2);
        }

    }

}
