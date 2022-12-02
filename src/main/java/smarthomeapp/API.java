package smarthomeapp;

import javafx.scene.control.Button;
import javafx.event.*;

public class API {


    public static int statuslicht;
    static  String AnAus;

    API(){

    }

    API(String wert){
        statuslicht++;
        this.AnAus = wert;

    }
    public void api(String anauswert){
        statuslicht++;
        this.AnAus = anauswert;
    }

}
