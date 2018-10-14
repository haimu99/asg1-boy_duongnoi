package sample.Dictionary;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ControllerAddWord extends ControllerGeneral {
    public void clickBackHome1(ActionEvent e) throws IOException
    {
        changeScene(e,"../Fxml/sample.fxml");
    }
}
