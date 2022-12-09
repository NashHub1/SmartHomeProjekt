package smarthomeapp.Vaadinpackage;

import javafx.scene.control.Button;
import javafx.event.*;

//Hier wird der Lichtstatus abgespeichert
public class API {

    public static boolean lightvalue1;
    public static boolean lightvalue2;

    API(){

    }

    public void api1(boolean lightvalue){
        this.lightvalue1 = lightvalue;
    }
    public void api2(boolean lightvalue){
        this.lightvalue2 = lightvalue;
    }

}
