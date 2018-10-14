package sample.Dictionary;


import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerGoogleTranslate extends ControllerGeneral {

    public void clickBackHome(ActionEvent e) throws IOException
    {
        changeScene(e,"../Fxml/sample.fxml");
    }
}
