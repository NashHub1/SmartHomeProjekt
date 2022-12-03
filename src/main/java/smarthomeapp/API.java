package smarthomeapp;

import javafx.scene.control.Button;
import javafx.event.*;

public class API {




    static boolean lightvalue1;
    static boolean lightvalue2;

    API(){

    }

    public void api1(boolean lightvalue){
        this.lightvalue1 = lightvalue;
    }
    public void api2(boolean lightvalue){
        this.lightvalue2 = lightvalue;
    }

}
